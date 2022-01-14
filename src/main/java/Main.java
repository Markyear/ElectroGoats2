import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage window = new Stage();
    public static final int TILE_SIZE = 16;
    public static final int KABELRADIUS = 7;
    public static String username = "";
    public enum Level {easy, ok, hard};
    public static Level level;
    public static int easyWhichQuestion = 0;
    public static int okWhichQuestion = 0;
    public static int hardWhichQuestion = 0;
    public static Questions thisGameQuestion;
    public static boolean gameResult = true;
    //public static Font font = Font.loadFont(Main.class.getResourceAsStream("ElectricFont.ttf"), 80);



        public static void main(String[] args) {
            launch(args);
        }

        public void start(Stage primaryStage) throws Exception {

         //   Font.loadFont(getClass().getResource("ElectricFont.ttf").toExternalForm(), 45);

            Parent root = FXMLLoader.load(getClass().getResource("StartWindow.fxml"));
            Scene scene = new Scene(root, 1000, 500);

            window = primaryStage;
            window.setScene(scene);
            //Größe des Fensters lässt sich nicht mehr verändern
            window.setResizable(false);
            window.centerOnScreen();
            window.show();
        }
}
