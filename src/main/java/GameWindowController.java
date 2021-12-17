import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class GameWindowController {


    //zum Verschieben der Kabel
    //zum Speichern der Mausposition
    double orgSceneX, orgSceneY;
    //zum Speichern der Ursprungsposition des Kabel während des Verschiebens
    double superorgScenx, superorgSceneY;

    //Array mit allen Pins vom Circuit Board
    Pins[][] circuitArray;

        @FXML
        private AnchorPane anchorPane;


    public void initialize(){

    CircuitBoard newCircuitborard = new CircuitBoard(100, 100, 15, 24, 20, anchorPane);
    circuitArray = newCircuitborard.getPinsBoard();


        Kabel kabel2 = new Kabel(130, 650, Color.YELLOW, anchorPane);
        kabel2.getCircle1().setOnMousePressed(mousePressedEventHandler);
        kabel2.getCircle1().setOnMouseDragged(mouseDraggedEventHandler);
        kabel2.getCircle1().setOnMouseReleased(mouseDroppedEventHandler);
        kabel2.getCircle2().setOnMousePressed(mousePressedEventHandler);
        kabel2.getCircle2().setOnMouseDragged(mouseDraggedEventHandler);
        kabel2.getCircle2().setOnMouseReleased(mouseDroppedEventHandler);

        Kabel kabel1 = new Kabel(100, 650, Color.BLUEVIOLET, anchorPane);
        kabel1.getCircle1().setOnMousePressed(mousePressedEventHandler);
        kabel1.getCircle1().setOnMouseDragged(mouseDraggedEventHandler);
        kabel1.getCircle1().setOnMouseReleased(mouseDroppedEventHandler);
        kabel1.getCircle2().setOnMousePressed(mousePressedEventHandler);
        kabel1.getCircle2().setOnMouseDragged(mouseDraggedEventHandler);
        kabel1.getCircle2().setOnMouseReleased(mouseDroppedEventHandler);

    }


    public EventHandler<MouseEvent> mousePressedEventHandler = (t) ->
    {
        orgSceneX = t.getSceneX();
        orgSceneY = t.getSceneY();

        Circle c = (Circle) (t.getSource());
        superorgScenx = c.getCenterX();
        superorgSceneY = c.getCenterY();

        //damit anderes Kabel oder Jumper auf den nun frei gewordenen Pin gesetzt werden kann
        Pins pin = whatPintoSetIsEmptyValue(c.getCenterX(),c.getCenterY());
        if (pin != null){pin.setAmIempty(true);}

        c.toFront();
    };
    private EventHandler<MouseEvent> mouseDraggedEventHandler = (t) ->
    {
        double offsetX = t.getSceneX() - orgSceneX;
        double offsetY = t.getSceneY() - orgSceneY;

        Circle c = (Circle) (t.getSource());

        c.setCenterX(c.getCenterX() + offsetX);
        c.setCenterY(c.getCenterY() + offsetY);

        orgSceneX = t.getSceneX();
        orgSceneY = t.getSceneY();
    };

    private EventHandler<MouseEvent> mouseDroppedEventHandler = (t)->
    {
        Circle c = (Circle) (t.getSource());

        //Kabel wird mittig auf Pin gesetzt, Pin wird auf "besetzt" gesetzt
        Pins targetPin = whatPinToPutKableOn(c.getCenterX(), c.getCenterY());

        if (targetPin == null){
            c.setCenterX(superorgScenx);
            c.setCenterY(superorgSceneY);

            // Falls Kabel wird an Ursprungsort zurückhüpft (da ausgesuchter Ort nicht geht) wird Pin auf "besetzt" geegeben
            targetPin = whatPintoSetIsEmptyValue(superorgScenx, superorgSceneY);
            if (targetPin != null){targetPin.setAmIempty(false);}
        }
       else {
            superorgScenx = (targetPin.getX()+(Main.TILE_SIZE/2));
            superorgSceneY = (targetPin.getY()+(Main.TILE_SIZE/2));
            c.setCenterX(superorgScenx);
            c.setCenterY(superorgSceneY);

        }};

//Methode um Pin zu finden auf den das Kabel mittels Maus gerade gezogen wurde
    private Pins whatPinToPutKableOn(double sceneX, double sceneY) {

        double leftCornerX = 0;
        double leftCornery= 0;
        Pins pin;

        for (int i = 0; i < circuitArray.length; i++) {
            for (int y = 0; y < circuitArray[i].length; y++) {
                pin = circuitArray[i][y];
                leftCornerX = pin.getX();
                leftCornery = pin.getY();

                if (leftCornerX < sceneX && sceneX < (leftCornerX + Main.TILE_SIZE) && leftCornery < sceneY && sceneY < (leftCornery + Main.TILE_SIZE) && pin.isAmIempty()) {
                    pin.setAmIempty(false);
                    return pin;
                }
            }
        }
        return null;
    }
    // Methode damit Pin von dem Kabel genommen wird wieder frei wird, bzw wieder als bestzt gespeichert wird wenn Kabel wieder
    //auf alte Position zurückhüpft
    private Pins whatPintoSetIsEmptyValue(double sceneX, double sceneY) {

        double leftCornerX = 0;
        double leftCornery= 0;
        double leftCornerXlookingFor = sceneX-(Main.TILE_SIZE/2);
        double leftCornerylookingfor= sceneY-(Main.TILE_SIZE/2);

        Pins pin;
        for (int i = 0; i < circuitArray.length; i++) {
            for (int y = 0; y < circuitArray[i].length; y++) {
                pin = circuitArray[i][y];
                leftCornerX = pin.getX();
                leftCornery = pin.getY();

                if (leftCornerX == leftCornerXlookingFor && leftCornery==leftCornerylookingfor) {
                    return pin;
                }
            }
        }
        return null;
    }


}