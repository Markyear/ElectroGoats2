import java.util.ArrayList;

public class OkGameQuestionBank {

    private Questions[] okQuestions;

    public OkGameQuestionBank(){

        //Question 1
        String question1Instruction = "Verbinden Sie den Microcontroller Pin A5 (Rechte Steckleiste 1 Spalte, 6 Zeile) über ein Kabel dem zweiten ein Kiloohm Widerstand des DRC-Netzwerk Boards \n" +
                "Den zweiten Anschluss des ein Kiloohm Widerstandes verbinden Sie mit über einen Jumper mit der Busleitung 4." +
                "Die Busleitung 4 verbinden Sie mit einem Jumper mit der Busleitung und 5 und die Busleitung 5 verbinden Sie mit einem Jumper mit der mit der Anode der ersten LED\n" +
                "Die Kathode der LED verbinden Sie über ein Kabel mit dem GND Anschluss des STM32L476-Nucleo Boards";
        String question1Code= "#include \"mbed.h\"\n" +
                "\n" +
                "DigitalOut myled(PA_5);\n" +
                "            \n" +
                "            int main() {\n" +
                "                     while(1) {\n" +
                "                          myled = 1;\n" +
                "                          wait(0.5);\n" +
                "                          myled = 0;\n" +
                "                          wait(1);\n" +
                "                          \n" +
                "                          \n";

        String question1Path = "src/main/resources/AnswerPictures/GPIO.PNG";

        String question1Volt = "????";

        //Kabel1(Gelb) von Mikrokontroller zum Steckboard
        Pins q1k1p1 = new Pins();
        q1k1p1.setX(355 + Main.TILE_SIZE/2 + Main.TILE_SIZE + 316 + Main.TILE_SIZE);
        q1k1p1.setY(372 + Main.TILE_SIZE/2 + 5 * Main.TILE_SIZE);
        Pins q1k1p2 = new Pins();
        q1k1p2.setX(355 + Main.TILE_SIZE/2 + Main.TILE_SIZE + 316 + Main.TILE_SIZE);
        q1k1p2.setY(372 + Main.TILE_SIZE/2 + 5 * Main.TILE_SIZE);
        Pins q1k1p3 = new Pins();
        q1k1p3.setX(795+ Main.TILE_SIZE/2 + 14 * Main.TILE_SIZE);
        q1k1p3.setY(128 + Main.TILE_SIZE/2 + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 5 * Main.TILE_SIZE);
        Pins q1k1p4 = new Pins();
        q1k1p4.setX(795+ (Main.TILE_SIZE/2) + 14 * Main.TILE_SIZE);
        q1k1p4.setY(128 + Main.TILE_SIZE/2 + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 7 * Main.TILE_SIZE);

        //Kabel2(Schwarz) von Mikrokontroller zum Steckboard
        Pins q1k2p1 = new Pins();
        q1k2p1.setX(795 + Main.TILE_SIZE/2 + 5 * Main.TILE_SIZE);
        q1k2p1.setY(128 + Main.TILE_SIZE/2 + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 91 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 86 + Main.TILE_SIZE + 3 * Main.TILE_SIZE);
        Pins q1k2p2 = new Pins();
        q1k2p2.setX(795+ Main.TILE_SIZE/2 + 26 * Main.TILE_SIZE);
        q1k2p2.setY(128 + Main.TILE_SIZE/2 + 3 * Main.TILE_SIZE + 85 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 91 + Main.TILE_SIZE + 7 * Main.TILE_SIZE + 86 + Main.TILE_SIZE + 3 * Main.TILE_SIZE);
        Pins q1k2p3 = new Pins();
        q1k2p3.setX(355 + Main.TILE_SIZE/2 + Main.TILE_SIZE);
        q1k2p3.setY(128 + Main.TILE_SIZE/2 + 9 * Main.TILE_SIZE);
        Pins q1k2p4 = new Pins();
        q1k2p4.setX(355 + Main.TILE_SIZE/2 + Main.TILE_SIZE);
        q1k2p4.setY(128 + Main.TILE_SIZE/2 + 10 * Main.TILE_SIZE);

        ArrayList<ResultPins> question1resultpins = new ArrayList<>();
        question1resultpins.add(new ResultPins(q1k1p1, q1k1p2, q1k1p3,q1k1p4));
        question1resultpins.add(new ResultPins(q1k2p1, q1k2p2, q1k2p3,q1k2p4));

        KoordinatenForJumper jumper1_1 = new KoordinatenForJumper(15, 15, 15, 15, 15, 16, 15, 16);
        KoordinatenForJumper jumper1_2 = new KoordinatenForJumper(1, 16, 27, 16, 1, 17, 27, 17);
        KoordinatenForJumper jumper1_3 = new KoordinatenForJumper(5, 23, 5, 23, 5, 24, 5, 24);
        ArrayList<KoordinatenForJumper> jumperArrayList = new ArrayList<>();
        jumperArrayList.add(jumper1_1);
        jumperArrayList.add(jumper1_2);
        jumperArrayList.add(jumper1_3);

        Questions questions1 = new Questions(question1Instruction, question1Code, question1Path, question1Volt, question1resultpins,jumperArrayList);

        okQuestions = new Questions[]{
                questions1
        };


    }

    public Questions[] getOkQuestions() {
        return okQuestions;
    }
}
