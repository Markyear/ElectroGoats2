import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class StartWindowController {

    @FXML
    private Label enterNameLabel;

    @FXML
    private ToggleGroup level;

    @FXML
    private Label levelLabel;

    @FXML
    private TextField nameTextfield;


    @FXML
    private RadioButton radioButtonLevel1;

    @FXML
    private RadioButton radioButtonLevel2;

    @FXML
    private RadioButton radioButtonLevel3;


    @FXML
    private Button startGame;

    @FXML
    // wenn der Button "start Game" gedrückt wird
    void startGame(ActionEvent event) throws IOException {
        Main.username = nameTextfield.getText();

        if(Main.username.equals("")) {
            nameTextfield.setPromptText("HEY, you forgot something!");
            nameTextfield.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
        }
        else {

        Parent root2 = FXMLLoader.load(getClass().getResource("GameWindow.fxml"));

        Scene scene = new Scene(root2);

        Main.window.setScene(scene);
        Main.window.show();



}}}
