import javafx.scene.layout.AnchorPane;

public abstract class VariousCercuitBoards {

    private Pins[][] pinsBoard;

    public VariousCercuitBoards() {

    }

    public static Pins[][] createpinsboard(int xAchse, int yAchse, int spalten, int zeilen, int abstand, AnchorPane anchorPane) {
        return new Pins[0][];
    }
}
