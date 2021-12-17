import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    public static Stage window = new Stage();
    public static final int TILE_SIZE = 20;
    public static final int KABELRADIUS = 7;

        public static void main(String[] args) {
            launch(args);
        }

        public void start(Stage primaryStage) throws Exception {
            URL url = new File("/Users/sandrabachinger-raithofer/IdeaProjects/ElectroGoats2/src/main/java/StartWindow.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);

            Scene scene = new Scene(root);
            window = primaryStage;
            window.setScene(scene);
            //Größe des Fensters lässt sich nicht mehr verändern
            window.setResizable(false);
            window.show();
        }
}
