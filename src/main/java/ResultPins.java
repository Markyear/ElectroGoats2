public class ResultPins {

    Pins pinForKabel1_1;
    Pins pinForKabel1_2;
    Pins pinForKabel2_1;
    Pins pinForKabel2_2;

    public ResultPins(Pins pinForKabel1_1, Pins pinForKabel1_2, Pins pinForKabel2_1, Pins pinForKabel2_2) {
        this.pinForKabel1_1 = pinForKabel1_1;
        this.pinForKabel1_2 = pinForKabel1_2;
        this.pinForKabel2_1 = pinForKabel2_1;
        this.pinForKabel2_2 = pinForKabel2_2;
    }

    public Pins getPinForKabel1_1() {
        return pinForKabel1_1;
    }

    public Pins getPinForKabel1_2() {
        return pinForKabel1_2;
    }

    public Pins getPinForKabel2_1() {
        return pinForKabel2_1;
    }

    public Pins getPinForKabel2_2() {
        return pinForKabel2_2;
    }
}
