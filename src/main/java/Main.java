import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {

        public static void main(String[] args) {
            launch(args);
        }

        public void start(Stage primaryStage) throws Exception {
            URL url = new File("C:\\Users\\Timeless-Laptop\\Documents\\JavaProjects\\ElectroGoats\\src\\main\\java\\StartWindow.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root, 800, 800);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
}
