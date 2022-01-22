import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InstructionsController {

    @FXML
    private Label headline;

    @FXML
    private Label text;


    @FXML
    private AnchorPane anchorpane;

    public void initialize() throws FileNotFoundException {
        javafx.scene.image.Image background2 = new javafx.scene.image.Image(new FileInputStream("src/main/resources/BackgroundPictures/background_game_window.jpg"));


        BackgroundImage bImg2 = new BackgroundImage(background2,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround2 = new Background(bImg2);
        anchorpane.setBackground(bGround2);


    }
}
