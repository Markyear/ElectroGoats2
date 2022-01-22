import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EndWindowController {

    @FXML
    private Button again;

    @FXML
    private AnchorPane anchorPaneEndWindow;

    @FXML
    private Button out;

    @FXML
    void againPlay(ActionEvent event) throws IOException {

        Parent root5 = FXMLLoader.load(getClass().getResource("StartWindow.fxml"));

        Scene scene = new Scene(root5, 1100, 700);

        Main.window.setScene(scene);
        Main.window.show();

    }

    @FXML
    void getOut(ActionEvent event) {

        Main.window.close();

    }

    public void initialize() throws FileNotFoundException {


        javafx.scene.image.Image image = new javafx.scene.image.Image(new FileInputStream("src/main/resources/BackgroundPictures/tree_finish_window.jpg"));
        //Setting the image view
        //ImageView imageView = new ImageView(image);
        BackgroundImage bImg = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);

        anchorPaneEndWindow.setBackground(bGround);
    }

}

