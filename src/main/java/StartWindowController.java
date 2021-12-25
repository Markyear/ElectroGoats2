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
    private Button instruction;

    @FXML
    void openInstructionsWindow(ActionEvent event) throws IOException {
        Stage secondStage = new Stage();

        Parent root2 = FXMLLoader.load(getClass().getResource("InstructionWindow.fxml"));

        Scene scene2 = new Scene(root2, 800, 800);
        secondStage.setScene(scene2);
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
    void easy(ActionEvent event) {
        Main.level = Main.Level.easy;

    }

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
        Main.username = nameTextfield.getText();

        if (Main.username.equals("")) {
            nameTextfield.setPromptText("HEY, we need some fax, no printer!");
            nameTextfield.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
        } else if (Main.level == null) {
            levelLabel.setText("Yo dog, you forgot something!");
            levelLabel.setTextFill(Color.RED);
        } else {

            Parent root2 = FXMLLoader.load(getClass().getResource("GameWindow.fxml"));

            Scene scene = new Scene(root2, 1500, 900);

            Main.window.setScene(scene);
            Main.window.show();


        }

    }

    public void initialize() throws FileNotFoundException {
        javafx.scene.image.Image background = new javafx.scene.image.Image(new FileInputStream("src/main/resources/BackgroundPictures/background_start_window.jpg"));
        //Setting the image view
        //ImageView imageView = new ImageView(image);
        BackgroundImage bImg = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        anchorpane.setBackground(bGround);
    }
}