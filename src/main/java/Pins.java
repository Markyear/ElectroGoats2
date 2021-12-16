import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Pins extends Rectangle {


        private Circle circle;

        public boolean hasPiece() {
            return circle != null;
        }

        public Circle getPiece() {
            return circle;
        }

        public Pins(int x, int y) {
            setWidth(Main.TILE_SIZE);
            setHeight(Main.TILE_SIZE);
            this.setFill(Color.LAVENDER);

        }

}
