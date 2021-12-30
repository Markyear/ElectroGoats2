import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Pins extends Rectangle {

        private boolean isEmpty;

        private Circle circle;

    public void setEmpty(boolean empty) {
        this.isEmpty = empty;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean hasPiece() {
            return circle != null;
        }

        public Circle getPiece() {
            return circle;
        }

        public Pins() {
            setWidth(Main.TILE_SIZE);
            setHeight(Main.TILE_SIZE);
            this.setFill(Color.TRANSPARENT);
            this.setStroke(Color.GREEN);
            this.setFill(Color.BLACK);
            this.isEmpty = true;
        }


}
