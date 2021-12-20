import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class ResultWindowController {

    @FXML
    private Button thanks;

    @FXML
    void thanks(ActionEvent event) throws IOException {
        Parent root4 = FXMLLoader.load(getClass().getResource("EndWindow.fxml"));

        Scene scene = new Scene(root4, 800, 1000);

        Main.window.setScene(scene);
        Main.window.show();
    }
}

