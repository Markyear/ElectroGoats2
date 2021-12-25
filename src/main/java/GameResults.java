import java.util.ArrayList;
import java.util.Iterator;

public class GameResults {

    ArrayList<Kabel> setKabelarray;
    Pins[][] circuitArray;
    Pins[][] microcontrollerArray;


    public GameResults(ArrayList<Kabel> setKabelarray,  Pins[][] circuitArray, Pins[][] microcontrollerArray) {
        this.setKabelarray = setKabelarray;
        this.circuitArray = circuitArray;
        this.microcontrollerArray = microcontrollerArray;
    }

    public Pins[][] getCircuitArray() {
        return circuitArray;
    }

    public Pins[][] getMicrocontrollerArray() {
        return microcontrollerArray;
    }

    public ArrayList<Kabel> getSetKabelarray() {
        return setKabelarray;
    }

    public void setSetKabelarray(ArrayList<Kabel> setKabelarray) {
        this.setKabelarray = setKabelarray;
    }

    public void printCircleCoordinates() {
        for (Kabel k : this.getSetKabelarray()) {
            System.out.println(k);
            System.out.println(k.getCircle1() + " " + k.getCircle2());
        }
    }

    public boolean checkResult(ArrayList<ResultPins> resultForThisGame) {

        //zum testen werden Kopien erstellt, damit bei erneuten testen wieder alles neu geprüft werden kann
       //https://www.delftstack.com/de/howto/java/copy-arraylist-java/
        ArrayList<Kabel> setKabelarraycopy = new ArrayList<>(this.setKabelarray);
        ArrayList<ResultPins> resultForThisGamecopy = new ArrayList<>(resultForThisGame);


        // wenn die Methode .remove in der Schleife aufgerufen wurde, wurde ein Concurrent Modification Exception Exception geworfen
        //daher wird iterators verwendet
        //https://www.geeksforgeeks.org/remove-element-arraylist-java/
        //https://www.geeksforgeeks.org/iterators-in-java/
        Iterator<Kabel> cabelterator = setKabelarraycopy.iterator();

        while (cabelterator.hasNext()) {
            //  Moving cursor to next element
            Kabel kabel = cabelterator.next();
            if (kabel.getCircle1().getCenterY() == 763
                    || kabel.getCircle1().getCenterY() == 763+5+Main.TILE_SIZE
           ||kabel.getCircle1().getCenterX()==(1245+(Main.TILE_SIZE/2))
                    //das zweite Rectangle wird auf 1281 gesetzt-> ka warum -> nur durch debugger draufgekommen
            || kabel.getCircle1().getCenterX() == 1281+Main.TILE_SIZE/2
            ){
                cabelterator.remove();}
        }

        double xOneside1, xOtherside1, yOneside1, yOtherside1;
        double xOneside2, xOtherside2, yOneside2, yOtherside2;

        Iterator<ResultPins> resultterator = resultForThisGamecopy.iterator();
        while (resultterator.hasNext()) {
            //  Moving cursor to next element
            ResultPins resultpin = resultterator.next();

            xOneside1 = resultpin.getPinForKabel1_1().getX();
            xOtherside1 = resultpin.getPinForKabel1_2().getX();
            yOneside1 = resultpin.getPinForKabel1_1().getY();
            yOtherside1 = resultpin.getPinForKabel1_2().getY();
            xOneside2 = resultpin.getPinForKabel2_1().getX();
            xOtherside2 = resultpin.getPinForKabel2_2().getX();
            yOneside2 = resultpin.getPinForKabel2_1().getY();
            yOtherside2 = resultpin.getPinForKabel2_2().getY();

            Iterator<Kabel> cabelterator2 = setKabelarraycopy.iterator();

            while (cabelterator2.hasNext()) {
                //  Moving cursor to next element
                Kabel kabel = cabelterator2.next();


                if (kabel.getCircle1().getCenterY() >= yOneside1 && yOtherside1 >= kabel.getCircle1().getCenterY() && kabel.getCircle1().getCenterX() >= xOneside1 && xOtherside1 >= kabel.getCircle1().getCenterX()) {
                    if (kabel.getCircle2().getCenterY() >= yOneside2 && yOtherside2 >= kabel.getCircle2().getCenterY() && kabel.getCircle2().getCenterX() >= xOneside2 && xOtherside2 >= kabel.getCircle2().getCenterX()) {
                        cabelterator2.remove();
                        resultterator.remove();
                    } else {
                        return false;
                    }
                } else if (kabel.getCircle2().getCenterY() >= yOneside1 && yOtherside1 >= kabel.getCircle2().getCenterY() && kabel.getCircle2().getCenterX() >= xOneside1 && xOtherside1 >= kabel.getCircle2().getCenterX()) {
                    if (kabel.getCircle1().getCenterY() >= yOneside2 && yOtherside2 >= kabel.getCircle1().getCenterY() && kabel.getCircle1().getCenterX() >= xOneside1 && xOtherside2 >= kabel.getCircle1().getCenterX()) {
                        cabelterator2.remove();
                        resultterator.remove();
                    } else {
                        return false;
                    }
                }
            }

        }
        // wenn resultForThisGame leer ist-> es wurden Kaben an den richtigen Stellen gesetzt
        //wenn das setKabelarray leer ist-> ist wurden nicht noch wo zusätzlich Kabel gesetzt
        if(resultForThisGamecopy.isEmpty()&& setKabelarraycopy.isEmpty()){
            return true;
        }
        else{
            return false;}
        }


}