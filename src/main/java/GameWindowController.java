import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class GameWindowController {

    //zum Verschieben der Kabel
    double orgSceneX, orgSceneY;

    @FXML
    private AnchorPane anchorPane;

    public void initialize(){

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
        circle2.setOnMousePressed(mousePressedEventHandler);
        circle2.setOnMouseDragged(mouseDraggedEventHandler);
        circle3.setOnMousePressed(mousePressedEventHandler);
        circle3.setOnMouseDragged(mouseDraggedEventHandler);
        circle4.setOnMousePressed(mousePressedEventHandler);
        circle4.setOnMouseDragged(mouseDraggedEventHandler);

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
        System.out.print(c1.centerXProperty().toString());
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

}