import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Pins extends Rectangle {

        private boolean amIempty;

        private Circle circle;

    public void setAmIempty(boolean amIempty) {
        this.amIempty = amIempty;
    }

    public boolean isAmIempty() {
        return amIempty;
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
            this.setStroke(Color.BLACK);
            this.amIempty = true;

        }


}
