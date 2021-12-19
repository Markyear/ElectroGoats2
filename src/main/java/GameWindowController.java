import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
// to uses media it hast to be added at modules in gradle -> 'javafx.media'
// https://stackoverflow.com/questions/62171410/error-package-javafx-scene-media-does-not-exist
import javafx.scene.media.MediaPlayer;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


public class GameWindowController {

    Media goatOK = new Media(getClass().getResource("Goat-Baby-Bah-B-www.fesliyanstudios.com.mp3").toExternalForm());
    MediaPlayer mediaPlayergoatOK = new MediaPlayer(goatOK);
    Media goatNotOK = new Media(getClass().getResource("Goat-Short-Cry-B-www.fesliyanstudios.com.mp3").toExternalForm());
    MediaPlayer mediaPlayergoatNotOK = new MediaPlayer(goatNotOK);



    //zum Verschieben der Kabel
    //zum Speichern der Mausposition
    double orgSceneX, orgSceneY;
    //zum Speichern der Ursprungsposition des Kabel während des Verschiebens
    double superorgScenx, superorgSceneY;

    //Array mit allen Pins vom Circuit Board
    Pins[][] circuitArray;
    Pins[][] microcontrollerArray;
    Pins[][] kabelstorageArray;
    Kabel [] gameResultKabelArray = new Kabel[Main.KABELAMOUNT];
    int kabelArrayCount = 0;





        @FXML
        private AnchorPane anchorPane;

    public GameWindowController() throws MalformedURLException, URISyntaxException {
    }


    public void initialize(){

    CircuitBoard newCircuitborard = new CircuitBoard(500, 100, 15, 24, 20, anchorPane);
    circuitArray = newCircuitborard.getPinsBoard();
    Microcontroller newMicrocontroller = new Microcontroller(20, 200, 4, 15, 180, anchorPane);
    microcontrollerArray = newMicrocontroller.getPinsBoard();
    Kabelstorage newKabelstorage = new Kabelstorage(20, 600, 8, 1, 5, anchorPane);
    kabelstorageArray = newKabelstorage.getPinsBoard();
    GameResults gameResults = new GameResults(gameResultKabelArray);

        Kabel kabel1 = new Kabel(35, 615, Color.BLUEVIOLET, anchorPane);
        setAllMouseEvents(kabel1, gameResults);
        //wherey + 25
        Kabel kabel2 = new Kabel(60, 615, Color.YELLOW, anchorPane);
        setAllMouseEvents(kabel2, gameResults);
        Kabel kabel3 = new Kabel(85, 615, Color.INDIGO, anchorPane);
        setAllMouseEvents(kabel3, gameResults);
        Kabel kabel4 = new Kabel(110, 615, Color.ORANGE, anchorPane);
        setAllMouseEvents(kabel4, gameResults);
        Kabel kabel5 = new Kabel(135, 615, Color.ORCHID, anchorPane);
        setAllMouseEvents(kabel5, gameResults);
        Kabel kabel6 = new Kabel(160, 615, Color.BURLYWOOD, anchorPane);
        setAllMouseEvents(kabel6, gameResults);
        Kabel kabel7 = new Kabel(185, 615, Color.HOTPINK, anchorPane);
        setAllMouseEvents(kabel7, gameResults);
        Kabel kabel8 = new Kabel(210, 615, Color.GOLD, anchorPane);
        setAllMouseEvents(kabel8, gameResults);


       gameResults.printCircleCoordinates();





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
        mediaPlayergoatOK.stop();
        mediaPlayergoatNotOK.stop();
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
            mediaPlayergoatNotOK.play();

        }
       else {
            superorgScenx = (targetPin.getX()+(Main.TILE_SIZE/2));
            superorgSceneY = (targetPin.getY()+(Main.TILE_SIZE/2));
            c.setCenterX(superorgScenx);
            c.setCenterY(superorgSceneY);

            mediaPlayergoatOK.play();


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
    private void setAllMouseEvents(Kabel kabel, GameResults gameResults){
        gameResults.getSetKabelarray()[kabelArrayCount] = kabel;
        kabelArrayCount++;
        kabel.getCircle1().setOnMousePressed(mousePressedEventHandler);
        kabel.getCircle1().setOnMouseDragged(mouseDraggedEventHandler);
        kabel.getCircle1().setOnMouseReleased(mouseDroppedEventHandler);
        kabel.getCircle2().setOnMousePressed(mousePressedEventHandler);
        kabel.getCircle2().setOnMouseDragged(mouseDraggedEventHandler);
        kabel.getCircle2().setOnMouseReleased(mouseDroppedEventHandler);


    }


}