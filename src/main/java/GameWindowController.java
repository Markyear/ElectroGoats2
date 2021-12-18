import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseButton;
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
    Pins[][] microcontrollerArray;
    Pins[][] kabelstorageArray;



        @FXML
        private AnchorPane anchorPane;


    public void initialize(){

    CircuitBoard newCircuitborard = new CircuitBoard(500, 100, 15, 24, 20, anchorPane);
    circuitArray = newCircuitborard.getPinsBoard();
    Microcontroller newMicrocontroller = new Microcontroller(20, 200, 4, 15, 180, anchorPane);
    microcontrollerArray = newMicrocontroller.getPinsBoard();
    Kabelstorage newKabelstorage = new Kabelstorage(20, 600, 8, 1, 5, anchorPane);
    kabelstorageArray = newKabelstorage.getPinsBoard();

        Kabel kabel1 = new Kabel(35, 615, Color.BLUEVIOLET, anchorPane);
        setAllMouseEvents(kabel1);
        //wherey + 25
        Kabel kabel2 = new Kabel(60, 615, Color.YELLOW, anchorPane);
        setAllMouseEvents(kabel2);
        Kabel kabel3 = new Kabel(85, 615, Color.INDIGO, anchorPane);
        setAllMouseEvents(kabel3);
        Kabel kabel4 = new Kabel(110, 615, Color.ORANGE, anchorPane);
        setAllMouseEvents(kabel4);
        Kabel kabel5 = new Kabel(135, 615, Color.ORCHID, anchorPane);
        setAllMouseEvents(kabel5);
        Kabel kabel6 = new Kabel(160, 615, Color.BURLYWOOD, anchorPane);
        setAllMouseEvents(kabel6);
        Kabel kabel7 = new Kabel(185, 615, Color.HOTPINK, anchorPane);
        setAllMouseEvents(kabel7);
        Kabel kabel8 = new Kabel(210, 615, Color.GOLD, anchorPane);
        setAllMouseEvents(kabel8);




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
        for (int i = 0; i < microcontrollerArray.length; i++) {
            for (int y = 0; y < microcontrollerArray[i].length; y++) {
                pin = microcontrollerArray[i][y];
                leftCornerX = pin.getX();
                leftCornery = pin.getY();

                if (leftCornerX < sceneX && sceneX < (leftCornerX + Main.TILE_SIZE) && leftCornery < sceneY && sceneY < (leftCornery + Main.TILE_SIZE) && pin.isAmIempty()) {
                    pin.setAmIempty(false);
                    return pin;
                }
            }
        }

        //am KabelstorageArray können  beide Kabeleldnen abgelegt werden (deshalb fehlt die Abfrage "isempty")
        for (int i = 0; i < kabelstorageArray.length; i++) {
            for (int y = 0; y < kabelstorageArray[i].length; y++) {
                pin = kabelstorageArray[i][y];
                leftCornerX = pin.getX();
                leftCornery = pin.getY();

                if (leftCornerX < sceneX && sceneX < (leftCornerX + Main.TILE_SIZE) && leftCornery < sceneY && sceneY < (leftCornery + Main.TILE_SIZE)) {
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
        for (int i = 0; i < microcontrollerArray.length; i++) {
            for (int y = 0; y < microcontrollerArray[i].length; y++) {
                pin = microcontrollerArray[i][y];
                leftCornerX = pin.getX();
                leftCornery = pin.getY();

                if (leftCornerX == leftCornerXlookingFor && leftCornery==leftCornerylookingfor) {
                    return pin;
                }
            }
        }
        return null;
    }
//Mouesevent für die Kreise von den Kabel werden gesetzt
    private void setAllMouseEvents(Kabel kabel){
        kabel.getCircle1().setOnMousePressed(mousePressedEventHandler);
        kabel.getCircle1().setOnMouseDragged(mouseDraggedEventHandler);
        kabel.getCircle1().setOnMouseReleased(mouseDroppedEventHandler);
        kabel.getCircle2().setOnMousePressed(mousePressedEventHandler);
        kabel.getCircle2().setOnMouseDragged(mouseDraggedEventHandler);
        kabel.getCircle2().setOnMouseReleased(mouseDroppedEventHandler);


    }


}