import javafx.scene.layout.AnchorPane;

public abstract class VariousCercuitBoard {

    private Pins[][] pinsBoard;

    public VariousCercuitBoard(int xAchse, int yAchse, int spalten, int zeilen, int abstand, AnchorPane anchorPane) {

        this.pinsBoard = createpinsboard(xAchse, yAchse, spalten, zeilen, abstand, anchorPane);
    }

   public static Pins[][] createpinsboard(int xAchse, int yAchse, int spalten, int zeilen, int abstand, AnchorPane anchorPane) {
        return new Pins[0][];
    }
}
