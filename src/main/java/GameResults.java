public class GameResults {

    Kabel[] setKabelarray;

    public GameResults(Kabel[] setKabelarray) {
        this.setKabelarray = setKabelarray;
    }

    public Kabel[] getSetKabelarray() {
        return setKabelarray;
    }

    public void setSetKabelarray(Kabel[] setKabelarray) {
        this.setKabelarray = setKabelarray;
    }

    public void printCircleCoordinates() {
        for (Kabel k : this.getSetKabelarray()) {
            System.out.println(k);
            System.out.println(k.getCircle1() + " " + k.getCircle2());
        }
    }
}