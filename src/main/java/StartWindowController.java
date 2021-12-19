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
    void startGame(ActionEvent event) throws IOException {

        Parent root2 = FXMLLoader.load(getClass().getResource("GameWindow.fxml"));

        Scene scene = new Scene(root2);

        Main.window.setScene(scene);
        Main.window.show();

    }

}
