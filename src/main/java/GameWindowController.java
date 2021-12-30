import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
// to uses media it hast to be added at modules in gradle -> 'javafx.media'
// https://stackoverflow.com/questions/62171410/error-package-javafx-scene-media-does-not-exist
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class GameWindowController {

    @FXML
    private Button TryOutButton;

    @FXML
    private Label code;

    @FXML
    private Label instruction;

    @FXML
    private AnchorPane anchorPane;

    Label voltLabel = new Label();

    @FXML
    private Button ceckVoltButton;

    @FXML
    void checkVolt(ActionEvent event) {
        boolean isset = true;
        for(Pins[] pinA : multimeterArray){
            for(Pins pin : pinA){
                if (pin.isEmpty() == true){
                    isset = false;
                    break;
                };
            }

        }
        if(gameResults.checkResult(resultForThisGame,jumperArrayList) && isset){
            voltLabel.setText(String.valueOf(Main.thisGameQuestion.getVolt()));
        }
        else {voltLabel.setText("ERROR");}

    }

    @FXML
    void tryOut(ActionEvent event) throws IOException {
        //gameResults.checkResult(resultForThisGame);
        Main.gameResult = gameResults.checkResult(resultForThisGame, jumperArrayList);
        Parent root3 = FXMLLoader.load(getClass().getResource("ResultWindow.fxml"));

        Scene scene = new Scene(root3);

        Main.window.setScene(scene);
        Main.window.centerOnScreen();
        Main.window.show();

    }
    Media goatOK = new Media(getClass().getResource("Sound/Goat2.mp3").toExternalForm());
    MediaPlayer mediaPlayergoatOK = new MediaPlayer(goatOK);
    Media goatNotOK = new Media(getClass().getResource("Sound/Goat1.mp3").toExternalForm());
    MediaPlayer mediaPlayergoatNotOK = new MediaPlayer(goatNotOK);

    EasyGameQuestionBank easyQuestion = new EasyGameQuestionBank();
    OkGameQuestionBank okQuestion = new OkGameQuestionBank();
    HardGameQuestionBank hardQuestion = new HardGameQuestionBank();

    Questions questionForThisGame;
    ArrayList<ResultPins> resultForThisGame = new ArrayList<>();
    ArrayList<KoordinatenForJumper> jumperArrayList = new ArrayList<>();
    GameResults gameResults;



    //zum Verschieben der Kabel
    //zum Speichern der Mausposition
    double orgSceneX, orgSceneY;
    //zum Speichern der Ursprungsposition des Kabel während des Verschiebens
    double superorgScenX, superorgSceneY;

    //Array mit allen Pins vom Circuit Board
    Pins[][] circuitArray;
    Pins[][] microcontrollerArray;
    Pins[][] kabelstorageArray;
    Pins[][] multimeterArray;
    ArrayList<Kabel> gameResultKabelArray = new ArrayList<>();


    public void initialize() throws FileNotFoundException {

        System.out.print(Main.level);
        if (Main.level == Main.Level.easy){
            questionForThisGame = easyQuestion.getEasyQuestions()[Main.easyWhichQuestion];
            Main.thisGameQuestion = questionForThisGame;
            Main.easyWhichQuestion++;
            if(Main.easyWhichQuestion == 2){
                Main.easyWhichQuestion = 0;
            }}
             else if (Main.level == Main.Level.ok){
                questionForThisGame = okQuestion.getOkQuestions()[Main.okWhichQuestion];
                 Main.thisGameQuestion = questionForThisGame;
             //   Main.okWhichQuestion++;
                if(Main.okWhichQuestion == 2){
                    Main.okWhichQuestion = 0;
                }
        }
        else if (Main.level == Main.Level.hard){
            questionForThisGame = hardQuestion.getHardQuestions()[Main.hardWhichQuestion];
            Main.thisGameQuestion = questionForThisGame;
        //    Main.hardWhichQuestion++;
            if(Main.hardWhichQuestion == 2){
                Main.hardWhichQuestion = 0;
            }}

        instruction.setText(questionForThisGame.getInstructions());
        code.setText(questionForThisGame.getCode());

        resultForThisGame = questionForThisGame.getResult();
        jumperArrayList = questionForThisGame.getJumpersResult();


       // Mikrokontroller image
        javafx.scene.image.Image image = new javafx.scene.image.Image(new FileInputStream("src/main/resources/BackgroundPictures/mikrokontroller.jpg"));
        ImageView mikrokontroller = new ImageView();
        mikrokontroller.setImage(image);
        mikrokontroller.setX(350);
        mikrokontroller.setY(190);
        mikrokontroller.setFitWidth(400);
        mikrokontroller.setFitHeight(500);

        // Circuitboard image
        javafx.scene.image.Image image2 = new javafx.scene.image.Image(new FileInputStream("src/main/resources/BackgroundPictures/circuitboard.jpg"));
        ImageView circuitboard = new ImageView();
        circuitboard.setImage(image2);
        circuitboard.setX(790);
        circuitboard.setY(80);
        circuitboard.setFitHeight(700);
        circuitboard.setFitWidth(450);

        // Multimeter image
        javafx.scene.image.Image image3 = new javafx.scene.image.Image(new FileInputStream("src/main/resources/BackgroundPictures/multimeter.jpg"));
        ImageView multimeter = new ImageView();
        multimeter.setImage(image3);
        multimeter.setX(1300);
        multimeter.setY(150);
        multimeter.setFitHeight(200);
        multimeter.setFitWidth(100);

        // Babygoat image
        javafx.scene.image.Image image4 = new javafx.scene.image.Image(new FileInputStream("src/main/resources/BackgroundPictures/babygoat.png"));
        ImageView babygoat = new ImageView();
        babygoat.setImage(image4);
        babygoat.setX(550);
        babygoat.setY(20);
        babygoat.setFitHeight(200);
        babygoat.setFitWidth(200);


        anchorPane.getChildren().addAll(mikrokontroller, circuitboard, multimeter,babygoat);


        code.setStyle("-fx-border-color: black ; -fx-border-width: 2px ;");
        instruction.setStyle("-fx-border-color: black ; -fx-border-width: 2px ;");


        //Label voltLabel = new Label();
        voltLabel.setText("XXXX");
        voltLabel.setLayoutX(1330);
        voltLabel.setLayoutY(190);


        javafx.scene.image.Image background = new javafx.scene.image.Image(new FileInputStream("src/main/resources/BackgroundPictures/background_game_window.jpg"));

        BackgroundImage bImg = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        anchorPane.setBackground(bGround);



        Label level = new Label("You chose level: " + Main.level);
        level.setLayoutX(30);
        level.setLayoutY(30);
        level.setFont(new Font(35));


        Label nametext = new Label(Main.username +", save Garrett the Goat!!");
        nametext.setLayoutX(30);
        nametext.setLayoutY(90);
        nametext.setFont(new Font(45));
        anchorPane.getChildren().addAll(nametext, voltLabel, level);

    CircuitBoard newCircuitborard = new CircuitBoard(795, 128, 27, 24, 85, 91, 86, anchorPane);
    circuitArray = newCircuitborard.getPinsBoard();
    Microcontroller newMicrocontroller = new Microcontroller(355, 372, 4, 19, 316, anchorPane);
    microcontrollerArray = newMicrocontroller.getPinsBoard();
    Kabelstorage newKabelstorage = new Kabelstorage(370, 750, 10, 2, 5, anchorPane);
    kabelstorageArray = newKabelstorage.getPinsBoard();
    MultimeterConnection newMultimeterConnection = new MultimeterConnection(1285, 175, 1, 4, 60, anchorPane);
    multimeterArray = newMultimeterConnection.getPinsBoard();
    gameResults = new GameResults(gameResultKabelArray,circuitArray,microcontrollerArray);


        int whereplus = 21;
        Kabel kabel1 = new Kabel(383, 763, Color.DEEPSKYBLUE, anchorPane);
        setAllMouseEvents(kabel1, gameResults);
        Kabel kabel2 = new Kabel(383 +whereplus, 763, Color.YELLOW, anchorPane);
        setAllMouseEvents(kabel2, gameResults);
        Kabel kabel3 = new Kabel(383 +2*whereplus, 763, Color.DEEPPINK, anchorPane);
        setAllMouseEvents(kabel3, gameResults);
        Kabel kabel4 = new Kabel(383 +3*whereplus, 763, Color.ORANGE, anchorPane);
        setAllMouseEvents(kabel4, gameResults);
        Kabel kabel5 = new Kabel(383 +4*whereplus, 763, Color.TURQUOISE, anchorPane);
        setAllMouseEvents(kabel5, gameResults);
        Kabel kabel6 = new Kabel(383 +5*whereplus, 763, Color.DEEPSKYBLUE, anchorPane);
        setAllMouseEvents(kabel6, gameResults);
        Kabel kabel7 = new Kabel(383 +6*whereplus, 763, Color.YELLOW, anchorPane);
        setAllMouseEvents(kabel7, gameResults);
        Kabel kabel8 = new Kabel(383 +7*whereplus, 763, Color.DEEPPINK, anchorPane);
        setAllMouseEvents(kabel8, gameResults);
        Kabel kabel9 = new Kabel(383 +8*whereplus, 763, Color.ORANGE, anchorPane);
        setAllMouseEvents(kabel9, gameResults);
        Kabel kabel10 = new Kabel(383 +9*whereplus, 763, Color.TURQUOISE, anchorPane);
        setAllMouseEvents(kabel10, gameResults);
        Kabel kabel11 = new Kabel(383 +9*whereplus, 763+whereplus, Color.DEEPSKYBLUE, anchorPane);
        setAllMouseEvents(kabel11, gameResults);
        Kabel kabel12 = new Kabel(383, 763+whereplus, Color.YELLOW, anchorPane);
        setAllMouseEvents(kabel12, gameResults);
        Kabel kabel13 = new Kabel(383 +whereplus, 763+whereplus, Color.DEEPPINK, anchorPane);
        setAllMouseEvents(kabel13, gameResults);
        Kabel kabel14 = new Kabel(383 +2*whereplus, 763+whereplus, Color.ORANGE, anchorPane);
        setAllMouseEvents(kabel14, gameResults);
        Kabel kabel15 = new Kabel(383 +3*whereplus, 763+whereplus, Color.TURQUOISE, anchorPane);
        setAllMouseEvents(kabel15, gameResults);
        Kabel kabel16 = new Kabel(383 +4*whereplus, 763+whereplus, Color.DEEPSKYBLUE, anchorPane);
        setAllMouseEvents(kabel16, gameResults);
        Kabel kabel17 = new Kabel(383 +5*whereplus, 763+whereplus, Color.YELLOW, anchorPane);
        setAllMouseEvents(kabel17, gameResults);
        Kabel kabel18 = new Kabel(383 +6*whereplus, 763+whereplus, Color.DEEPPINK, anchorPane);
        setAllMouseEvents(kabel18, gameResults);
        Kabel kabel19 = new Kabel(383 +7*whereplus, 763+whereplus, Color.ORANGE, anchorPane);
        setAllMouseEvents(kabel19, gameResults);
        Kabel kabel20 = new Kabel(383 +8*whereplus, 763+whereplus, Color.TURQUOISE, anchorPane);
        setAllMouseEvents(kabel20, gameResults);

       // Circle circletest1 = new Circle(1281+Main.TILE_SIZE/2, 175+Main.TILE_SIZE/2, Main.KABELRADIUS, Color.RED);
       // anchorPane.getChildren().add(circletest1);

     //  gameResults.printCircleCoordinates();

        //test visually the calculateed results of our game
    /*   Circle circle11 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(0).getPinForKabel1_1().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(0).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.RED);
        Circle circle12 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(0).getPinForKabel1_2().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(0).getPinForKabel1_2().getY(),Main.KABELRADIUS, Color.RED);
        Circle circle13 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(0).getPinForKabel2_1().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(0).getPinForKabel2_1().getY(),Main.KABELRADIUS, Color.RED);
        Circle circle14 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(0).getPinForKabel2_2().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(0).getPinForKabel2_2().getY(),Main.KABELRADIUS, Color.RED);

        Circle circle21 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(1).getPinForKabel1_1().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(1).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.BLUE);
        Circle circle22 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(1).getPinForKabel1_2().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(1).getPinForKabel1_2().getY(),Main.KABELRADIUS, Color.BLUE);
        Circle circle23 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(1).getPinForKabel2_1().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(1).getPinForKabel2_1().getY(),Main.KABELRADIUS, Color.BLUE);
        Circle circle24 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(1).getPinForKabel2_2().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(1).getPinForKabel2_2().getY(),Main.KABELRADIUS, Color.BLUE);

        Circle circle31 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(2).getPinForKabel1_1().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(2).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.BEIGE);
        Circle circle32 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(2).getPinForKabel1_2().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(2).getPinForKabel1_2().getY(),Main.KABELRADIUS, Color.BEIGE);
        Circle circle33 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(2).getPinForKabel2_1().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(2).getPinForKabel2_1().getY(),Main.KABELRADIUS, Color.BEIGE);
        Circle circle34 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(2).getPinForKabel2_2().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(2).getPinForKabel2_2().getY(),Main.KABELRADIUS, Color.BEIGE);

        Circle circle41 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(3).getPinForKabel1_1().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(3).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.VIOLET);
        Circle circle42 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(3).getPinForKabel1_2().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(3).getPinForKabel1_2().getY(),Main.KABELRADIUS, Color.VIOLET);
        Circle circle43 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(3).getPinForKabel2_1().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(3).getPinForKabel2_1().getY(),Main.KABELRADIUS, Color.VIOLET);
        Circle circle44 = new Circle(easyQuestion.getEasyQuestions()[1].getResult().get(3).getPinForKabel2_2().getX(),easyQuestion.getEasyQuestions()[1].getResult().get(3).getPinForKabel2_2().getY(),Main.KABELRADIUS, Color.VIOLET);

     /*  Circle circle21 = new Circle(hardQuestion.getHardQuestions()[0].getResult().get(1).getPinForKabel1_1().getX(),hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.RED);
        Circle circle22 = new Circle(hardQuestion.getHardQuestions()[0].getResult().get(1).getPinForKabel1_2().getX(),hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.RED);
        Circle circle23 = new Circle(hardQuestion.getHardQuestions()[0].getResult().get(1).getPinForKabel2_1().getX(),hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.RED);
        Circle circle24 = new Circle(hardQuestion.getHardQuestions()[0].getResult().get(1).getPinForKabel2_2().getX(),hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.RED);

        Circle circle31 = new Circle(hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_1().getX(),hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.RED);
        Circle circle32 = new Circle(hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_2().getX(),hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.RED);
        Circle circle33 = new Circle(hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel2_1().getX(),hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.RED);
        Circle circle34 = new Circle(hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel2_2().getX(),hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.RED);

        Circle circle41 = new Circle(hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_1().getX(),hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.RED);
        Circle circle42 = new Circle(hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_2().getX(),hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.RED);
        Circle circle43 = new Circle(hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel2_1().getX(),hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.RED);
        Circle circle44 = new Circle(hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel2_2().getX(),hardQuestion.getHardQuestions()[0].getResult().get(0).getPinForKabel1_1().getY(),Main.KABELRADIUS, Color.RED);*/
    //  anchorPane.getChildren().addAll(circle11,circle12,circle13, circle14,circle21,circle22,circle23, circle24,circle31,circle32,circle33, circle34, circle41,circle42,circle43, circle44);
        //anchorPane.getChildren().addAll(circle11,circle12,circle13, circle14);
      //  anchorPane.getChildren().addAll(circle11,circle12,circle13, circle14,circle21,circle22,circle23, circle24);

    }




    public EventHandler<MouseEvent> mousePressedEventHandler = (t) ->
    {
        orgSceneX = t.getSceneX();
        orgSceneY = t.getSceneY();

        Circle c = (Circle) (t.getSource());
        superorgScenX = c.getCenterX();
        superorgSceneY = c.getCenterY();

        //damit anderes Kabel oder Jumper auf den nun frei gewordenen Pin gesetzt werden kann
        Pins pin = whatPintoSetIsEmptyValue(c.getCenterX(),c.getCenterY());
        if (pin != null){pin.setEmpty(true);}

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
            c.setCenterX(superorgScenX);
            c.setCenterY(superorgSceneY);

            // Falls Kabel wird an Ursprungsort zurückhüpft (da ausgesuchter Ort nicht geht) wird Pin auf "besetzt" geegeben
            targetPin = whatPintoSetIsEmptyValue(superorgScenX, superorgSceneY);
            if (targetPin != null){targetPin.setEmpty(false);}
            mediaPlayergoatNotOK.play();

        }
       else {
            superorgScenX = (targetPin.getX()+(Main.TILE_SIZE/2));
            superorgSceneY = (targetPin.getY()+(Main.TILE_SIZE/2));
            c.setCenterX(superorgScenX);
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
                if(circuitArray[i][y]!=null){
                pin = circuitArray[i][y];
                leftCornerX = pin.getX();
                leftCornery = pin.getY();

                if (leftCornerX < sceneX && sceneX < (leftCornerX + Main.TILE_SIZE) && leftCornery < sceneY && sceneY < (leftCornery + Main.TILE_SIZE) && pin.isEmpty()) {
                    pin.setEmpty(false);
                    return pin;
                }}
            }
        }
        for (int i = 0; i < microcontrollerArray.length; i++) {
            for (int y = 0; y < microcontrollerArray[i].length; y++) {
                pin = microcontrollerArray[i][y];
                leftCornerX = pin.getX();
                leftCornery = pin.getY();

                if (leftCornerX < sceneX && sceneX < (leftCornerX + Main.TILE_SIZE) && leftCornery < sceneY && sceneY < (leftCornery + Main.TILE_SIZE) && pin.isEmpty()) {
                    pin.setEmpty(false);
                    return pin;
                }
            }
        }
        for (int i = 0; i < multimeterArray.length; i++) {
            for (int y = 0; y < multimeterArray[i].length; y++) {
                pin = multimeterArray[i][y];
                leftCornerX = pin.getX();
                leftCornery = pin.getY();

                if (leftCornerX < sceneX && sceneX < (leftCornerX + Main.TILE_SIZE) && leftCornery < sceneY && sceneY < (leftCornery + Main.TILE_SIZE) && pin.isEmpty()) {
                    pin.setEmpty(false);
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
                    pin.setEmpty(false);
                    return pin;
                }
            }
        }
        return null;
    }
    // Methode damit Pin von dem Kabel genommen wird wieder frei wird, bzw wieder als bestzt gespeichert wird wenn Kabel wieder
    //auf alte Position zurückhüpft
    private Pins whatPintoSetIsEmptyValue(double sceneX, double sceneY) {

        double leftUpperCornerX = 0;
        double leftUpperCornerY= 0;
        double leftCornerXlookingFor = sceneX-(Main.TILE_SIZE/2);
        double leftCornerylookingfor= sceneY-(Main.TILE_SIZE/2);

        Pins pin;
        for (int i = 0; i < circuitArray.length; i++) {
            for (int y = 0; y < circuitArray[i].length; y++) {
                if(circuitArray[i][y]!=null){
                pin = circuitArray[i][y];
                leftUpperCornerX = pin.getX();
                leftUpperCornerY = pin.getY();

                if (leftUpperCornerX == leftCornerXlookingFor && leftUpperCornerY==leftCornerylookingfor) {
                    return pin;
                }}
            }
        }
        for (int i = 0; i < microcontrollerArray.length; i++) {
            for (int y = 0; y < microcontrollerArray[i].length; y++) {
                pin = microcontrollerArray[i][y];
                leftUpperCornerX = pin.getX();
                leftUpperCornerY = pin.getY();

                if (leftUpperCornerX == leftCornerXlookingFor && leftUpperCornerY==leftCornerylookingfor) {
                    return pin;
                }
            }
        }
        for (int i = 0; i < multimeterArray.length; i++) {
            for (int y = 0; y < multimeterArray[i].length; y++) {
                pin = multimeterArray[i][y];
                leftUpperCornerX = pin.getX();
                leftUpperCornerY = pin.getY();

                if (leftUpperCornerX == leftCornerXlookingFor && leftUpperCornerY==leftCornerylookingfor) {
                    return pin;
                }
            }
        }
        return null;
    }
//Mouseevent für die Kreise von den Kabel werden gesetzt + werden in das Überprüfungsarray gegeben
    private void setAllMouseEvents(Kabel kabel, GameResults gameResults){
        gameResults.getSetKabelarray().add(kabel);
        kabel.getCircle1().setOnMousePressed(mousePressedEventHandler);
        kabel.getCircle1().setOnMouseDragged(mouseDraggedEventHandler);
        kabel.getCircle1().setOnMouseReleased(mouseDroppedEventHandler);
        kabel.getCircle2().setOnMousePressed(mousePressedEventHandler);
        kabel.getCircle2().setOnMouseDragged(mouseDraggedEventHandler);
        kabel.getCircle2().setOnMouseReleased(mouseDroppedEventHandler);

    }

}