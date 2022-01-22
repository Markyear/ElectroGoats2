import java.util.ArrayList;

public class HardGameQuestionBank {
    private Questions[] hardQuestions;

    public HardGameQuestionBank(){

        //Question 1
        String question1Instruction = "Verbinde den Pin aus der 2 Spalte und 19 Zeile des Microcontrollers mit dem 1 untersten 1 Kiloohmwiderstand am unteren Ende des Boards." +
                "Verbinde den oberen Teil des ein Kiloohmwiderstandes mit einem Jumper mit der Busleitung 5." +
                "Verbinde die Busleitung 5 mit einem Jumper mit der ersten LED und verbinde das andere Ende der LED mit einem Jumper mit der Busleitung 6." +
                "Verbinde den Pin aus der 2 Spalte und 18 Zeile des Microcontrollers mit dem mittleren 1 Kiloohmwiderstand an der mittleren unteren Steckleiste des Boards." +
                "Verbinde den oberen Teil des ein Kiloohmwiderstandes mit einem Jumper mit der Busleitung 3." +
                "Verbinde die Busleitung 2 mit einem Jumper mit der ersten LED und verbinde das andere Ende der LED mit einem Jumper mit der Busleitung 4." +
                "Verbinde den Pin aus der 1 Spalte und 18 Zeile des Microcontrollers mit dem obersten 1 Kiloohmwiderstand an der mittleren oberen Steckleiste des Boards." +
                "Verbinde den oberen Teil des ein Kiloohmwiderstandes mit einem Jumper mit der Busleitung 1." +
                "Verbinde die Busleitung 1 mit einem Jumper mit der ersten LED und verbinde das andere Ende der LED mit einem Jumper mit der Busleitung 2." +
                "Verbinde nun den Ground Anschluss vom Microcontroller mit dem ersten Steckplatz der Busleitung 4" +
                "Verbinde nun die Busleitung 4 mit der Busleitung 2 und mit der Busleitung 6";


        String question1Code= "#include \"mbed.h\"\n" +
                "\n" +
                "Ticker toggle_led1_ticker;\n" +
                "DigitalOut led1(PA_5);\n" +
                "            \n" +
                "void toggle_led1() {\n" +
                "led1 = !led1;\n" +
                "}\n" +
                "            \n" +
                "            int main() {\n" +
                "toggle_led1_ticker.attach(&toggle_led1, 0.1);\n" +
                "}";

        String question1Path = "src/main/resources/AnswerPictures/Timer.PNG";

        String question1Volt = "3.5 Volt";

        //Kabel1(Violett) von Mikrokontroller zum Steckboard
        Pins q1k1p1 = new Pins();
        q1k1p1.setX(355 + Main.TILE_SIZE/2);
        q1k1p1.setY(372 + Main.TILE_SIZE/2 + 18 * Main.TILE_SIZE);
        Pins q1k1p2 = new Pins();
        q1k1p2.setX(355 + Main.TILE_SIZE/2);
        q1k1p2.setY(372 + Main.TILE_SIZE/2 + 18 * Main.TILE_SIZE);
        Pins q1k1p3 = new Pins();
        q1k1p3.setX(795 + Main.TILE_SIZE/2 + 14 * Main.TILE_SIZE);
        q1k1p3.setY(128 + (Main.TILE_SIZE/2) + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE);
        Pins q1k1p4 = new Pins();
        q1k1p4.setX(795 + Main.TILE_SIZE/2 + 14 * Main.TILE_SIZE);
        q1k1p4.setY(128 + (Main.TILE_SIZE/2) + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 2 * Main.TILE_SIZE);

        //Kabel2(Gelb) von Mikrokontroller zum Steckboard
        Pins q1k2p1 = new Pins();
        q1k2p1.setX(355 + Main.TILE_SIZE/2 + Main.TILE_SIZE);
        q1k2p1.setY(372 + Main.TILE_SIZE/2 + 17 * Main.TILE_SIZE);
        Pins q1k2p2 = new Pins();
        q1k2p2.setX(355 + Main.TILE_SIZE/2 + Main.TILE_SIZE);
        q1k2p2.setY(372 + Main.TILE_SIZE/2 + 17 * Main.TILE_SIZE);
        Pins q1k2p3 = new Pins();
        q1k2p3.setX(795 + Main.TILE_SIZE/2 + 14 * Main.TILE_SIZE);
        q1k2p3.setY(128 + (Main.TILE_SIZE/2) + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 91 + Main.TILE_SIZE);
        Pins q1k2p4 = new Pins();
        q1k2p4.setX(795 + Main.TILE_SIZE/2 + 14 * Main.TILE_SIZE);
        q1k2p4.setY(128 + (Main.TILE_SIZE/2) + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 91 + Main.TILE_SIZE + 2 * Main.TILE_SIZE);

        //Kabel3(Blau) von Mikrokontroller zum Steckboard
        Pins q1k3p1 = new Pins();
        q1k3p1.setX(355 + Main.TILE_SIZE/2 + Main.TILE_SIZE);
        q1k3p1.setY(372 + Main.TILE_SIZE/2 + 18 * Main.TILE_SIZE);
        Pins q1k3p2 = new Pins();
        q1k3p2.setX(355 + Main.TILE_SIZE/2 + Main.TILE_SIZE);
        q1k3p2.setY(372 + Main.TILE_SIZE/2 + 18 * Main.TILE_SIZE);
        Pins q1k3p3 = new Pins();
        q1k3p3.setX(795 + Main.TILE_SIZE/2 + 14 * Main.TILE_SIZE);
        q1k3p3.setY(128 + (Main.TILE_SIZE/2) + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 8 * Main.TILE_SIZE + 91 + 8* Main.TILE_SIZE + 86 + Main.TILE_SIZE);
        Pins q1k3p4 = new Pins();
        q1k3p4.setX(795 + Main.TILE_SIZE/2 + 14 * Main.TILE_SIZE);
        q1k3p4.setY(128 + (Main.TILE_SIZE/2) + 4 * Main.TILE_SIZE + 85 + 7 * Main.TILE_SIZE + 91 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 86 + Main.TILE_SIZE + 2 * Main.TILE_SIZE);

        //Kabel4(Schwarz) von Mikrokontroller zum Steckboard
        Pins q1k4p1 = new Pins();
        q1k4p1.setX(355 + Main.TILE_SIZE/2 + Main.TILE_SIZE);
        q1k4p1.setY(372 + Main.TILE_SIZE/2 + 10 * Main.TILE_SIZE);
        Pins q1k4p2 = new Pins();
        q1k4p2.setX(355 + Main.TILE_SIZE/2 + Main.TILE_SIZE);
        q1k4p2.setY(372 + Main.TILE_SIZE/2 + 10 * Main.TILE_SIZE);
        Pins q1k4p3 = new Pins();
        q1k4p3.setX(795 + Main.TILE_SIZE/2);
        q1k4p3.setY(128 + (Main.TILE_SIZE/2) + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 91 + Main.TILE_SIZE + 3 * Main.TILE_SIZE);
        Pins q1k4p4 = new Pins();
        q1k4p4.setX(795 + Main.TILE_SIZE/2);
        q1k4p4.setY(128 + (Main.TILE_SIZE/2) + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 91 + Main.TILE_SIZE + 3 * Main.TILE_SIZE);

        //Kabel5(Schwarz) von Steckboard zum Steckboard nach oben
        Pins q1k5p1 = new Pins();
        q1k5p1.setX(795 + Main.TILE_SIZE/2 + Main.TILE_SIZE);
        q1k5p1.setY(128 + Main.TILE_SIZE/2 + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 91 + Main.TILE_SIZE + 3 * Main.TILE_SIZE);
        Pins q1k5p2 = new Pins();
        q1k5p2.setX(795 + Main.TILE_SIZE/2 + 26 *  Main.TILE_SIZE);
        q1k5p2.setY(128 + Main.TILE_SIZE/2 + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 91 + Main.TILE_SIZE + 3 * Main.TILE_SIZE);
        Pins q1k5p3 = new Pins();
        q1k5p3.setX(795 + Main.TILE_SIZE/2);
        q1k5p3.setY(128 + (Main.TILE_SIZE/2) + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 3 * Main.TILE_SIZE);
        Pins q1k5p4 = new Pins();
        q1k5p4.setX(795 + Main.TILE_SIZE/2 + 26 * Main.TILE_SIZE);
        q1k5p4.setY(128 + (Main.TILE_SIZE/2) + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 3 * Main.TILE_SIZE);


        //Kabel6(Schwarz) von Steckboard zum Steckboard nach unten
        Pins q1k6p1 = new Pins();
        q1k6p1.setX(795 + Main.TILE_SIZE/2 + Main.TILE_SIZE);
        q1k6p1.setY(128 + Main.TILE_SIZE/2 + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 91 + Main.TILE_SIZE + 3 * Main.TILE_SIZE);
        Pins q1k6p2 = new Pins();
        q1k6p2.setX(795 + Main.TILE_SIZE/2 + 26 * Main.TILE_SIZE);
        q1k6p2.setY(128 + Main.TILE_SIZE/2 + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 91 + Main.TILE_SIZE + 3 * Main.TILE_SIZE);
        Pins q1k6p3 = new Pins();
        q1k6p3.setX(795 + Main.TILE_SIZE/2);
        q1k6p3.setY(128 + (Main.TILE_SIZE/2) + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 91 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 86 + Main.TILE_SIZE + 3 * Main.TILE_SIZE);
        Pins q1k6p4 = new Pins();
        q1k6p4.setX(795 + Main.TILE_SIZE/2 + 26 * Main.TILE_SIZE);
        q1k6p4.setY(128 + (Main.TILE_SIZE/2) + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 91 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 86 + Main.TILE_SIZE + 3 * Main.TILE_SIZE);




        ArrayList<ResultPins> question1resultpins = new ArrayList<>();
        question1resultpins.add(new ResultPins(q1k1p1, q1k1p2, q1k1p3, q1k1p4));
        question1resultpins.add(new ResultPins(q1k2p1, q1k2p2, q1k2p3, q1k2p4));
        question1resultpins.add(new ResultPins(q1k3p1, q1k3p2, q1k3p3, q1k3p4));
        question1resultpins.add(new ResultPins(q1k4p1, q1k4p2, q1k4p3, q1k4p4));
        question1resultpins.add(new ResultPins(q1k5p1, q1k5p2, q1k5p3, q1k5p4));
        question1resultpins.add(new ResultPins(q1k6p1, q1k6p2, q1k6p3, q1k6p4));

        KoordinatenForJumper jumper1_1 = new KoordinatenForJumper(15, 2, 15, 2, 15, 1, 15, 1);
        KoordinatenForJumper jumper1_2 = new KoordinatenForJumper(5, 1, 5, 1, 5, 2, 5, 2);
        KoordinatenForJumper jumper1_3 = new KoordinatenForJumper(5, 7, 5, 7, 5, 8, 5, 8);

        KoordinatenForJumper jumper1_4 = new KoordinatenForJumper(15, 10, 15, 10, 15, 9, 15, 9);
        KoordinatenForJumper jumper1_5 = new KoordinatenForJumper(5, 9, 5, 9, 5, 10, 5, 10);
        KoordinatenForJumper jumper1_6 = new KoordinatenForJumper(5, 15, 5, 15, 5, 16, 5, 16);

        KoordinatenForJumper jumper1_7 = new KoordinatenForJumper(15, 18, 15, 18, 15, 17, 15, 17);
        KoordinatenForJumper jumper1_8 = new KoordinatenForJumper(5, 17, 5, 17, 5, 18, 5, 18);
        KoordinatenForJumper jumper1_9 = new KoordinatenForJumper(5, 23, 5, 23, 5, 24, 5, 24);


        ArrayList<KoordinatenForJumper> jumperArrayList = new ArrayList<>();
        jumperArrayList.add(jumper1_1);
        jumperArrayList.add(jumper1_2);
        jumperArrayList.add(jumper1_3);
        jumperArrayList.add(jumper1_4);
        jumperArrayList.add(jumper1_5);
        jumperArrayList.add(jumper1_6);
        jumperArrayList.add(jumper1_7);
        jumperArrayList.add(jumper1_8);
        jumperArrayList.add(jumper1_9);

        Questions questions1 = new Questions(question1Instruction, question1Code, question1Path, question1Volt, question1resultpins,jumperArrayList);

        hardQuestions = new Questions[]{
                questions1
        };
    }

    public Questions[] getHardQuestions() {
        return hardQuestions;
    }

}
