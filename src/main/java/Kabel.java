import javafx.scene.Cursor;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;



public class Kabel {

    Circle circle1;
    Circle circle2;
    Line line;

    public Kabel(int wherex, int whery, javafx.scene.paint.Color color, AnchorPane anchorPane) {

        circle1 = new Circle(wherex,whery, Main.KABELRADIUS, color);
        circle1.setCursor(Cursor.OPEN_HAND);
        circle2 = new Circle(wherex,whery, Main.KABELRADIUS, color);
        circle2.setCursor(Cursor.OPEN_HAND);
        line = connect(circle1, circle2);
        anchorPane.getChildren().addAll(circle1, circle2, line);
        circle1.toFront();
        circle2.toFront();

    }

    public Circle getCircle1() {
        return circle1;
    }

    public Circle getCircle2() {
        return circle2;
    }

    public Line connect(Circle c1, Circle c2)
    {
        Line line = new Line();
        line.startXProperty().bind(c1.centerXProperty());
        line.startYProperty().bind(c1.centerYProperty());

        line.endXProperty().bind(c2.centerXProperty());
        line.endYProperty().bind(c2.centerYProperty());

        javafx.scene.paint.Color color = (Color)c1.getFill();
        line.setStroke(color);

        line.setStrokeWidth(3);

        return line;
    }
}
