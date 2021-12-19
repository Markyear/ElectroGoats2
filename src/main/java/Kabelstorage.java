import javafx.scene.layout.AnchorPane;

public class Kabelstorage extends VariousCercuitBoards {
    private Pins[][] pinsBoard;

    public Kabelstorage (int xAchse, int yAchse, int spalten, int zeilen, int abstand, AnchorPane anchorPane) {

        this.pinsBoard = createpinsboard(xAchse, yAchse, spalten, zeilen, abstand, anchorPane);
    }


    public Pins[][] getPinsBoard() {
        return pinsBoard;
    }


    // pins werden direkt in der Scene sichtbar gemacht und gleichzeitig in einem zweidimensionalen Arry gespeichert
    public static Pins[][] createpinsboard(int xAchse, int yAchse, int spalten, int zeilen, int abstand, AnchorPane anchorPane){
        Pins[][] pinsArray = new Pins[zeilen][spalten];
        int pinxAchse = xAchse;
        int pinyAchse = yAchse;

        for(int e = 0; e < zeilen; e++, pinyAchse = pinyAchse+Main.TILE_SIZE){
            pinyAchse = pinyAchse+abstand;

            pinxAchse = xAchse;
            for (int i = 0; i < spalten; i++, pinxAchse = pinxAchse+Main.TILE_SIZE) {
                pinxAchse = pinxAchse+abstand;
                Pins pin = new Pins();
                pin.setX(pinxAchse);
                pin.setY(pinyAchse);

                pinsArray[e][i] = pin;
                anchorPane.getChildren().add(pin);
            }
        }


        return pinsArray;
    }
}
