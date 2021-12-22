import javafx.fxml.FXML;
import javafx.scene.layout.*;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EndWindowController {

    @FXML
    private AnchorPane anchorPaneEndWindow;

    public void initialize() throws FileNotFoundException {


        javafx.scene.image.Image image = new javafx.scene.image.Image(new FileInputStream("src/main/resources/BackgroundPictures/GoatsOnTree.png"));
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

