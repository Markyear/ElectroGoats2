import java.util.ArrayList;

public class Questions {

    private String instructions;
    private String code;
    private String pathToResultPicture;
    private double volt;
    private ArrayList<ResultPins> result = new ArrayList<>();

    public Questions(String instructions, String code, String pathToResultPicture, double volt,  ArrayList<ResultPins> result) {
        this.instructions = instructions;
        this.code = code;
        this.pathToResultPicture = pathToResultPicture;
        this.volt = volt;
        this.result = result;
    }

    public double getVolt() {
        return volt;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getCode() {
        return code;
    }

    public String getPathToResultPicture() {
        return pathToResultPicture;
    }

    public  ArrayList<ResultPins>  getResult() {
        return result;
    }


}
