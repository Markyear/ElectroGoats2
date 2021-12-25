import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class RightAnswerWindowController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private AnchorPane anchorpane2;

    @FXML
    private Label label;



    public void initialize() throws FileNotFoundException {
        javafx.scene.image.Image image = new javafx.scene.image.Image(new FileInputStream(Main.thisGameQuestion.getPathToResultPicture()));

        ImageView result = new ImageView();
        result.setImage(image);
        result.setX(20);
        result.setY(190);
        result.setFitWidth(660);
        result.setFitHeight(450);

        anchorPane.getChildren().add(result);


        javafx.scene.image.Image background = new javafx.scene.image.Image(new FileInputStream("src/main/resources/BackgroundPictures/background_game_window.jpg"));

        BackgroundImage bImg = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        anchorPane.setBackground(bGround);

    }

}
