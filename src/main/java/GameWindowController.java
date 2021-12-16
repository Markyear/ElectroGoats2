import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class GameWindowController {

    //zum Verschieben der Kabel
    double orgSceneX, orgSceneY;
    double superorgScenx, superorgSceneY;

    ArrayList<Pins> pinsArrayList = new ArrayList<>();


        @FXML
        private AnchorPane anchorPane;

        @FXML
        private BorderPane borderPane;

        @FXML
        private HBox hboxi;

    public void initialize(){

        int x =100;
        int y = 100;
        for (int i = 0; i < 8; i++, x = x+Main.TILE_SIZE) {
            Pins pin = new Pins(10, 10);
            if (i%2 == 0){
                pin.setFill(Color.GRAY);}
                pin.setX(x);
                pin.setY(y);
                pinsArrayList.add(pin);
                System.out.print(pin.getX());

            anchorPane.getChildren().add(pin);}


        Circle circle1 = new Circle(100, 400, 10, Color.PURPLE);
        circle1.setCursor(Cursor.OPEN_HAND);

        Circle circle2 = new Circle(150, 400, 10, Color.PURPLE);
        circle2.setCursor(Cursor.OPEN_HAND);

        Circle circle3 = new Circle(200, 400, 10, Color.YELLOW);
        circle3.setCursor(Cursor.OPEN_HAND);

        Circle circle4 = new Circle(250, 400, 10, Color.YELLOW);
        circle4.setCursor(Cursor.OPEN_HAND);

    Line line1 = connect(circle1, circle2);
    Line line2 = connect(circle3, circle4);
        circle1.setOnMousePressed(mousePressedEventHandler);
        circle1.setOnMouseDragged(mouseDraggedEventHandler);
        circle1.setOnMouseReleased(mouseDroppedEventHandler);
        circle2.setOnMousePressed(mousePressedEventHandler);
        circle2.setOnMouseDragged(mouseDraggedEventHandler);
        circle2.setOnMouseReleased(mouseDroppedEventHandler);
        circle3.setOnMousePressed(mousePressedEventHandler);
        circle3.setOnMouseDragged(mouseDraggedEventHandler);
        circle3.setOnMouseReleased(mouseDroppedEventHandler);
        circle4.setOnMousePressed(mousePressedEventHandler);
        circle4.setOnMouseDragged(mouseDraggedEventHandler);
        circle4.setOnMouseReleased(mouseDroppedEventHandler);

        circle1.toFront();
        circle2.toFront();
        circle3.toFront();
        circle4.toFront();

    anchorPane.getChildren().addAll(circle1, circle2, circle3, circle4,line1, line2);
    }

    public Line connect(Circle c1, Circle c2)
    {
        Line line = new Line();
        line.startXProperty().bind(c1.centerXProperty());
        line.startYProperty().bind(c1.centerYProperty());

        line.endXProperty().bind(c2.centerXProperty());
        line.endYProperty().bind(c2.centerYProperty());

        Color color = (Color)c1.getFill();
        line.setStroke(color);

        line.setStrokeWidth(3);

        return line;

    }

    private EventHandler<MouseEvent> mousePressedEventHandler = (t) ->
    {
        orgSceneX = t.getSceneX();
        orgSceneY = t.getSceneY();
        superorgScenx = t.getSceneX();
        superorgSceneY = t.getSceneY();

// bring the clicked circle to the front

        Circle c = (Circle) (t.getSource());
        c.toFront();
    };
    private EventHandler<MouseEvent> mouseDraggedEventHandler = (t) ->
    {
        double offsetX = t.getSceneX() - orgSceneX;
        double offsetY = t.getSceneY() - orgSceneY;

        Circle c = (Circle) (t.getSource());

        c.setCenterX(c.getCenterX() + offsetX);
        c.setCenterY(c.getCenterY() + offsetY);

        orgSceneX = t.getSceneX();
        orgSceneY = t.getSceneY();
    };

    private EventHandler<MouseEvent> mouseDroppedEventHandler = (t)->
    {
        Circle c = (Circle) (t.getSource());
        Pins targetPin = whatPin(c.getCenterX(), c.getCenterY());

        if (targetPin == null){
            c.setCenterX(superorgScenx);
            c.setCenterY(superorgSceneY);
        }
       else {
            superorgScenx = (targetPin.getX()+(Main.TILE_SIZE/2));
            superorgSceneY = (targetPin.getY()+(Main.TILE_SIZE/2));
            c.setCenterX(superorgScenx);
            c.setCenterY(superorgSceneY);

        }};

    private Pins whatPin(double sceneX, double sceneY) {

        double leftCornerX;
        double leftCornery;

        for (Pins pin : pinsArrayList){
            leftCornerX = pin.getX();
            leftCornery = pin.getY();

            if (leftCornerX<sceneX && sceneX<(leftCornerX+Main.TILE_SIZE) && leftCornery < sceneY && sceneY<(leftCornery+Main.TILE_SIZE)){

                return pin;
            }
        }

       return null;
    }

}