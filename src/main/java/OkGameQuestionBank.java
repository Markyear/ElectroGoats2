import java.util.ArrayList;

public class OkGameQuestionBank {

    private Questions[] okQuestions;

    public OkGameQuestionBank(){

        //Question 1
        String question1Instruction = "Setze 1x ganz links oben am CircuitB und einmal links oben entweder 4,3 oder 2t Reihe + setze einen Jumper um Buslinie 2 und 3 zu verbinden";
        String question1Code= "#include \"mbed.h\"\n" +
                "\n" +
                "DigitalOut myled(PA_5);\n" +
                "Serial pc(PA_2, PA_3); //tx, rx\n" +
                "            \n" +
                "            int s = 40;\n" +
                "            int m = 59;\n" +
                "            int h = 0;\n" +
                "            \n" +
                "            int main() {\n" +
                "                     while(1) {\n" +
                "                          pc.printf(\"%2d:%2d:%d\\r\",h, m, s);\n" +
                "                          \n" +
                "                         // myled=!myled;";

        String question1Path = "src/main/resources/AnswerPictures/easy1.png";

        String question1Volt = "3.8 Volt";

        //Kabel1 von Mikrokontroller zum Steckboard
        Pins q1k1p1 = new Pins();
        q1k1p1.setX(795+ Main.TILE_SIZE/2);
        q1k1p1.setY(128+Main.TILE_SIZE/2);
        Pins q1k1p2 = new Pins();
        q1k1p2.setX(795+ Main.TILE_SIZE/2);
        q1k1p2.setY(128+Main.TILE_SIZE/2);
        Pins q1k2p1 = new Pins();
        q1k2p1.setX(795+ Main.TILE_SIZE/2);
        q1k2p1.setY(128+(Main.TILE_SIZE/2)+Main.TILE_SIZE);
        Pins q1k2p2 = new Pins();
        q1k2p2.setX(795+ Main.TILE_SIZE/2);
        q1k2p2.setY(128+(Main.TILE_SIZE/2)+(3*Main.TILE_SIZE));

        ArrayList<ResultPins> question1resultpins = new ArrayList<>();
        question1resultpins.add(new ResultPins(q1k1p1, q1k1p2, q1k2p1,q1k2p2));

        KoordinatenForJumper jumper1 = new KoordinatenForJumper(1, 7, 26, 7, 1, 8, 26, 8);
        ArrayList<KoordinatenForJumper> jumperArrayList = new ArrayList<>();
        jumperArrayList.add(jumper1);

        Questions questions1 = new Questions(question1Instruction, question1Code, question1Path, question1Volt, question1resultpins,jumperArrayList);

        okQuestions = new Questions[]{
                questions1
        };


    }

    public Questions[] getOkQuestions() {
        return okQuestions;
    }
}
