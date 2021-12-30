import java.util.ArrayList;

public class EasyGameQuestionBank {

    private Questions[] easyQuestions;

    public EasyGameQuestionBank(){

        //Question 1
        String question1Instruction = "Widerstandsmessung von 10k\n" +
                "Instructions:\n" +
                "Auf der Platte wird das Multimeter angeschlossen: COM-Anschluss an Blau und V-Anschluss an Gelb\n" +
                "Multimeteranschluss: COM-Anschluss (Blau) wird an dem 10k Widerstand mit der Busleitung 4 und der V-Anschluss (Gelb) wird an dem 10k Widerstand mit der Busleitung 3 verbunden\n";
        String question1Code= "You do not need any code for this one";

        String question1Path = "src/main/resources/AnswerPictures/easy1.jpg";

        String question1Volt = "0.47";

//Kabel 1
        Pins q1k1p1 = new Pins();
        q1k1p1.setX(795+ Main.TILE_SIZE/2+17*Main.TILE_SIZE);
        q1k1p1.setY(128+Main.TILE_SIZE/2+ 85 + 9*Main.TILE_SIZE);
        Pins q1k1p2 = new Pins();
        q1k1p2.setX(795+ Main.TILE_SIZE/2+17*Main.TILE_SIZE);
        q1k1p2.setY(128+Main.TILE_SIZE/2+ 85 + 11*Main.TILE_SIZE);
        Pins q1k1p3 = new Pins();
        q1k1p3.setX(795+ Main.TILE_SIZE/2+30+(26*Main.TILE_SIZE));
        q1k1p3.setY(128+(Main.TILE_SIZE/2));
        Pins q1k1p4 = new Pins();
        q1k1p4.setX(795+ Main.TILE_SIZE/2+30+(26*Main.TILE_SIZE));
        q1k1p4.setY(128+(Main.TILE_SIZE/2));



//Kabel 2
        Pins q1k2p1 = new Pins();
        q1k2p1.setX(795+ Main.TILE_SIZE/2+17*Main.TILE_SIZE);
        q1k2p1.setY(128+Main.TILE_SIZE/2+85+91+12*Main.TILE_SIZE);
        Pins q1k2p2 = new Pins();
        q1k2p2.setX(795+ Main.TILE_SIZE/2+17*Main.TILE_SIZE);
        q1k2p2.setY(128+Main.TILE_SIZE/2+85+91+14*Main.TILE_SIZE);
        Pins q1k2p3 = new Pins();
        q1k2p3.setX(795+ Main.TILE_SIZE/2+30+(26*Main.TILE_SIZE));
        q1k2p3.setY(128+(Main.TILE_SIZE/2)+Main.TILE_SIZE);
        Pins q1k2p4 = new Pins();
        q1k2p4.setX(795+ Main.TILE_SIZE/2+30+(26*Main.TILE_SIZE));
        q1k2p4.setY(128+(Main.TILE_SIZE/2)+Main.TILE_SIZE);


        ArrayList<ResultPins> question1resultpins = new ArrayList<>();
        question1resultpins.add(new ResultPins(q1k1p1, q1k1p2, q1k1p3,q1k1p4));
        question1resultpins.add(new ResultPins(q1k2p1, q1k2p2, q1k2p3,q1k2p4));

       // KoordinatenForJumper jumper1 = new KoordinatenForJumper(1, 7, 26, 7, 1, 8, 26, 8);
        ArrayList<KoordinatenForJumper> jumperArrayList = new ArrayList<>();
       // jumperArrayList.add(jumper1);

       Questions questions1 = new Questions(question1Instruction, question1Code, question1Path, question1Volt, question1resultpins,jumperArrayList);

        //Question 2
        String question2Instruction = "Strommessung mit dem Widerstand R = 10 \n" +
                "Instructions:\n" +
                "Verbinde den mittleren 10k durch einen Jumper mit der Busleitung 4 und einen weiteren Jumper um diesen Widerstand mit der Busleitung 3 zu verbinden\n" +
                "Busleitungen 2/3 und 4/5 müssen am äußersten Rand verbunden werden\n" +
                "Der +5V Anschluss des MC wird mit der Busleitung 3 verbunden\n" +
                "Der Ground Anschluss mit der Busleitung 6\n" +
                "Multimeteranschluss: COM-Anschluss wird mit der Busleitung 6 und der V-Anschluss mit der Busleitung 3 verbunden\n" +
                "Auf der Platte wird das Multimeter angeschlossen: COM-Anschluss an Blau und V-Anschluss an Gelb\n";

        String question2Code= "You do not need any code for this one";

        String question2Path = "src/main/resources/AnswerPictures/easy2.jpg";

        String question2Volt = "0.99" ;

        //Kabel 1 von Mikrokontroller zum Circuitboard 355, 372
        Pins q2k1p1 = new Pins();
        q2k1p1.setX(355+ Main.TILE_SIZE/2+Main.TILE_SIZE);
        q2k1p1.setY(372+Main.TILE_SIZE/2+8*Main.TILE_SIZE);
        Pins q2k1p2 = new Pins();
        q2k1p2.setX(355+ Main.TILE_SIZE/2+Main.TILE_SIZE);
        q2k1p2.setY(372+Main.TILE_SIZE/2+8*Main.TILE_SIZE);
        Pins q2k1p3 = new Pins();
        q2k1p3.setX(795+ Main.TILE_SIZE/2);
        q2k1p3.setY(128+(Main.TILE_SIZE/2)+(4*Main.TILE_SIZE)+85+(4*Main.TILE_SIZE));
        Pins q2k1p4 = new Pins();
        q2k1p4.setX(795+ Main.TILE_SIZE/2+26*Main.TILE_SIZE);
        q2k1p4.setY(128+(Main.TILE_SIZE/2)+(4*Main.TILE_SIZE)+85+(4*Main.TILE_SIZE));


        //Kabel 2 von Mikrokontroller zum Circuitboard
       Pins q2k2p1 = new Pins();
        q2k2p1.setX(355+ Main.TILE_SIZE/2+Main.TILE_SIZE);
        q2k2p1.setY(372+Main.TILE_SIZE/2+9*Main.TILE_SIZE);
        Pins q2k2p2 = new Pins();
        q2k2p2.setX(355+ Main.TILE_SIZE/2+Main.TILE_SIZE);
        q2k2p2.setY(372+Main.TILE_SIZE/2+10*Main.TILE_SIZE);
        Pins q2k2p3 = new Pins();
        q2k2p3.setX(795+ Main.TILE_SIZE/2);
        q2k2p3.setY(128+(Main.TILE_SIZE/2)+85+91+86+(23*Main.TILE_SIZE));
        Pins q2k2p4 = new Pins();
        q2k2p4.setX(795+ Main.TILE_SIZE/2+26*Main.TILE_SIZE);
        q2k2p4.setY(128+(Main.TILE_SIZE/2)+85+91+86+(23*Main.TILE_SIZE));

        //Kabel 3 von Circuitboard zum Multimeter
        Pins q2k3p1 = new Pins();
        q2k3p1.setX(795+ Main.TILE_SIZE/2);
        q2k3p1.setY(128+(Main.TILE_SIZE/2)+(4*Main.TILE_SIZE)+85+91+(12*Main.TILE_SIZE));
        Pins q2k3p2 = new Pins();
        q2k3p2.setX(795+ Main.TILE_SIZE/2+26*Main.TILE_SIZE);
        q2k3p2.setY(128+(Main.TILE_SIZE/2)+(4*Main.TILE_SIZE)+85+91+(12*Main.TILE_SIZE));
        Pins q2k3p3 = new Pins();
        q2k3p3.setX(795+ Main.TILE_SIZE/2+30+(26*Main.TILE_SIZE));
        q2k3p3.setY(128+(Main.TILE_SIZE/2));
        Pins q2k3p4 = new Pins();
        q2k3p4.setX(795+ Main.TILE_SIZE/2+30+(26*Main.TILE_SIZE));
        q2k3p4.setY(128+(Main.TILE_SIZE/2));

        //Kabel 4 von Circuitboard zum Multimeter
       Pins q2k4p1 = new Pins();
        q2k4p1.setX(795+ Main.TILE_SIZE/2);
        q2k4p1.setY(128+(Main.TILE_SIZE/2)+85+91+86+(23*Main.TILE_SIZE));
        Pins q2k4p2 = new Pins();
        q2k4p2.setX(795+ Main.TILE_SIZE/2+26*Main.TILE_SIZE);
        q2k4p2.setY(128+(Main.TILE_SIZE/2)+85+91+86+(23*Main.TILE_SIZE));
        Pins q2k4p3 = new Pins();
        q2k4p3.setX(795+ Main.TILE_SIZE/2+30+(26*Main.TILE_SIZE));
        q2k4p3.setY(128+(Main.TILE_SIZE/2)+Main.TILE_SIZE);
        Pins q2k4p4 = new Pins();
        q2k4p4.setX(795+ Main.TILE_SIZE/2+30+(26*Main.TILE_SIZE));
        q2k4p4.setY(128+(Main.TILE_SIZE/2)+Main.TILE_SIZE);

        ArrayList<ResultPins> question2resultpins = new ArrayList<>();
        question2resultpins.add(new ResultPins(q2k1p1, q2k1p2, q2k1p3,q2k1p4));
        question2resultpins.add(new ResultPins(q2k2p1, q2k2p2, q2k2p3,q2k2p4));
        question2resultpins.add(new ResultPins(q2k3p1, q2k3p2, q2k3p3,q2k3p4));
        question2resultpins.add(new ResultPins(q2k4p1, q2k4p2, q2k4p3,q2k4p4));

        KoordinatenForJumper jumper2_1 = new KoordinatenForJumper(1, 8, 27, 8, 1, 9, 27, 9);
        KoordinatenForJumper jumper2_2 = new KoordinatenForJumper(1, 16, 27, 16, 1, 17, 27, 17);
        KoordinatenForJumper jumper2_3 = new KoordinatenForJumper(18, 9, 18, 9, 18, 10, 18, 10);
        KoordinatenForJumper jumper2_4 = new KoordinatenForJumper(18, 15, 18, 15, 18, 16, 18, 16);

        ArrayList<KoordinatenForJumper> jumperArrayList2 = new ArrayList<>();
           jumperArrayList2.add(jumper2_1);
           jumperArrayList2.add(jumper2_2);
           jumperArrayList2.add(jumper2_3);
           jumperArrayList2.add(jumper2_4);

        Questions questions2 = new Questions(question2Instruction, question2Code, question2Path, question2Volt, question2resultpins,jumperArrayList2);

    easyQuestions = new Questions[]{
            questions1,
            questions2
    };
    }

    public Questions[] getEasyQuestions() {
        return easyQuestions;
    }
}
