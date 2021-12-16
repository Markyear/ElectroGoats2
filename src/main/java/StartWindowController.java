import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Button startGame;

    @FXML
    void startGame(ActionEvent event) throws MalformedURLException {
        Stage primaryStage = new Stage();
        URL url = new File("/Users/sandrabachinger-raithofer/IdeaProjects/ElectroGoats2/src/main/java/GameWindow.fxml").toURI().toURL();
        Parent root2 = null;
        try {
            root2 = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root2, 800, 800);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
