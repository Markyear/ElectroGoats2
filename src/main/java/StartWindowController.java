import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class StartWindowController {


    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Label enterNameLabel;

    @FXML
    private ToggleGroup level;

    @FXML
    private Label levelLabel;

    @FXML
    private TextField nameTextfield;

    @FXML
    private Label headline;

    @FXML
    private Button instruction;


    @FXML
    void openInstructionsWindow(ActionEvent event) throws IOException {
        Stage secondStage = new Stage();
        Font font = Font.loadFont(getClass().getResourceAsStream("ElectricFont2.ttf"), 40);

        Parent root2 = FXMLLoader.load(getClass().getResource("InstructionWindow.fxml"));

        Scene scene2 = new Scene(root2, 800, 800);
        secondStage.setScene(scene2);
        secondStage.centerOnScreen();
        secondStage.show();
    }


    @FXML
    private RadioButton radioButtonLevel1;

    @FXML
    private RadioButton radioButtonLevel2;

    @FXML
    private RadioButton radioButtonLevel3;


    @FXML
    private Button startGame;

    @FXML
    void easy(ActionEvent event) { Main.level = Main.Level.easy; }

    @FXML
    void hard(ActionEvent event) {
        Main.level = Main.Level.hard;
    }

    @FXML
    void ok(ActionEvent event) {
        Main.level = Main.Level.ok;
    }


    @FXML
        // wenn der Button "start Game" gedrückt wird
    void startGame(ActionEvent event) throws IOException {

           //falls Username nicht eingegeben wurde
        if (Main.username.equals("")) {
            nameTextfield.setPromptText("HEY, we need your name, all fax, no printer!");
            nameTextfield.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            //falls Level nicht ausgewählt wurde
        } else if (Main.level == null) {
            levelLabel.setText("Yo dog, you forgot something!");
            levelLabel.setTextFill(Color.RED);
            //neue Scene wird geladen
        } else {

            Parent root2 = FXMLLoader.load(getClass().getResource("GameWindow.fxml"));

            Scene scene = new Scene(root2, 1500, 900);

            Main.window.setScene(scene);
            Main.window.centerOnScreen();
            Main.window.show();

        }

    }

    public void initialize() throws FileNotFoundException {
        Font font = Font.loadFont(getClass().getResourceAsStream("ElectricFont2.ttf"), 90);

        headline.setFont(font);

       // headline.setTextFill(Color.WHITESMOKE);

    //falls bereits die zweite Runde gespielt wird, wird vorgeschlagen, ob Name und Level beibehalten werden soll
        if (!Main.username.equals("")) {
            enterNameLabel.setText("Wanne stay with the name " + Main.username + " ?");
            nameTextfield.setPromptText(Main.username);}

        if (Main.level!=null) {
            levelLabel.setText("Your set level is: " + Main.level + ". Do you wanne change it?");}

        // wenn im Namensfeld etwas getippt wird, wird das getippte in Main.username gespeichert
        nameTextfield.textProperty().addListener(observable -> Main.username = nameTextfield.getText());

        javafx.scene.image.Image background = new javafx.scene.image.Image(new FileInputStream("src/main/resources/BackgroundPictures/background_start_window.jpg"));

        BackgroundImage bImg = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        anchorpane.setBackground(bGround);
    }
}