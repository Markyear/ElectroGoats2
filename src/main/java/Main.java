import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    public static Stage window = new Stage();
    public static final int KABELAMOUNT = 8;
    public static final int TILE_SIZE = 20;
    public static final int KABELRADIUS = 7;
    public static String username = "";




        public static void main(String[] args) {
            launch(args);
        }

        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("StartWindow.fxml"));
            Scene scene = new Scene(root, 1000, 500);

            window = primaryStage;
            window.setScene(scene);
            //Größe des Fensters lässt sich nicht mehr verändern
            window.setResizable(false);
            window.show();
        }
}
