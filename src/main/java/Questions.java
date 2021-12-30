import java.util.ArrayList;

public class Questions {

    private String instructions;
    private String code;
    private String pathToResultPicture;
    private String ergebnis;
    private ArrayList<ResultPins> result = new ArrayList<>();
    private ArrayList<KoordinatenForJumper> jumpersResult = new ArrayList<>();


    public Questions(String instructions, String code, String pathToResultPicture, String ergebnis,  ArrayList<ResultPins> result, ArrayList<KoordinatenForJumper> jumpersResult) {
        this.instructions = instructions;
        this.code = code;
        this.pathToResultPicture = pathToResultPicture;
        this.ergebnis = ergebnis;
        this.result = result;
        this.jumpersResult = jumpersResult;
    }

    public String getVolt() {
        return ergebnis;
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

    public ArrayList<KoordinatenForJumper> getJumpersResult() {
        return jumpersResult;
    }
}
