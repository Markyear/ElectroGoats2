import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class CircuitBoard extends VariousCercuitBoards {


    private Pins[][] pinsBoard;

    public CircuitBoard(int xAchse, int yAchse, int spalten, int zeilen, int abstand,int abstand2, int abstand3, AnchorPane anchorPane) {

        this.pinsBoard = createpinsboard(xAchse, yAchse, spalten, zeilen, abstand, abstand2, abstand3, anchorPane);
    }


    public Pins[][] getPinsBoard() {
        return pinsBoard;
    }




    // pins werden direkt in der Scene sichtbar gemacht und gleichzeitig in einem zweidimensionalen Arry gespeichert
    public static Pins[][] createpinsboard(int xAchse, int yAchse, int spalten, int zeilen, int abstand, int abstand2, int abstand3, AnchorPane anchorPane){
        Pins[][] pinsArray = new Pins[zeilen][spalten+1];
        int pinxAchse = xAchse;
        int pinyAchse = yAchse;

        for(int e = 0; e < zeilen; e++, pinyAchse = pinyAchse+Main.TILE_SIZE){
            if(e==4){
                pinyAchse = pinyAchse+abstand;
            }
            if (e == 12 ){
                pinyAchse = pinyAchse+abstand2;
            }
            if (e == 20){
                pinyAchse = pinyAchse+abstand3;
            }
            pinxAchse = xAchse;
        for (int i = 0; i < spalten; i++, pinxAchse = pinxAchse+Main.TILE_SIZE) {
            Pins pin = new Pins();
            pin.setX(pinxAchse);
            pin.setY(pinyAchse);

            if( (e ==0 || e== 1) && i == (spalten-1)){
                Pins pinfurMessen = new Pins();
                pinfurMessen.setX(pinxAchse+30);
                pinfurMessen.setY(pinyAchse);
                pinsArray[e][spalten] = pinfurMessen;
                anchorPane.getChildren().add(pinfurMessen);

                if(e==0){
                    pinfurMessen.setFill(Color.YELLOW);
                }
                else{pinfurMessen.setFill(Color.BLUE);}
            }
            // bei Doppelklick auf Pin wird ein Teil des "jumpers" gesetzt -> der Pin wird rot
            // beim erneuten Doppelklick wird der Pin wieder frei
            pin.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    if(t.getButton().equals(MouseButton.PRIMARY)) {
                        if (t.getClickCount() == 2) {

                            Pins pin = (Pins) (t.getSource());
                            Color color = (Color) pin.getFill();
                            if (color == Color.RED){
                                pin.setEmpty(true);
                                pin.setFill(Color.BLACK);

                            }
                            else {
                            pin.setFill(Color.RED);
                            pin.setEmpty(false);
                }}
            }
                }});

            pinsArray[e][i] = pin;
            anchorPane.getChildren().add(pin);

            }
            }


        return pinsArray;


    }

}



