import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ResultWindowController {

    @FXML
    private Button thanks;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private AnchorPane anchorpane2;

    @FXML
    private Label result;


    @FXML
    void thanks(ActionEvent event) throws IOException {
        // System.out.print(Main.gameResult);
        Parent root4 = FXMLLoader.load(getClass().getResource("EndWindow.fxml"));

        Scene scene = new Scene(root4, 1100, 700);

        Main.window.setScene(scene);
        Main.window.centerOnScreen();
        Main.window.show();
    }

    public void initialize() throws FileNotFoundException {
      Image image = null;
      thanks.setLayoutX(425);
      thanks.setLayoutY(350);

        if (Main.gameResult==false){
             image = new Image(new File("src/main/resources/GoatVideos/goat-fall.gif").toURI().toString());
            result.setText("Ohh noo, you were wrong, look what you did to Garrett!");
            result.setAlignment(Pos.CENTER);

            Button getRightAnswer = new Button("Wanne get the right answer?");
            getRightAnswer.setLayoutY(300);
            getRightAnswer.setLayoutX(425);

            thanks.setText("No thanks");

            getRightAnswer.setOnAction(new EventHandler(){

                @Override
                public void handle(Event event) {Stage secondStage = new Stage();
                thanks.setText("Next step");
                    Parent root2 = null;
                    try {
                        root2 = FXMLLoader.load(getClass().getResource("RightAnswerWindow.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Scene scene2 = new Scene(root2, 700, 800);
                    secondStage.setScene(scene2);
                    secondStage.centerOnScreen();
                    secondStage.show();

                }


                });

            anchorpane.getChildren().add(getRightAnswer);
            }

        else if (Main.gameResult==true){
             image = new Image(new File("src/main/resources/GoatVideos/happy.gif").toURI().toString());
            result.setText("Uff congrats you saved Garrett!");

        }


        BackgroundImage bImg = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        Background bGround = new Background(bImg);

        anchorpane2.setBackground(bGround);

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
