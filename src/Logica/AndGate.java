package Logica;

public class AndGate implements GateInterface {
    private final String input1;
    private final String input2;
    private final String output;


    public AndGate(){
        input1 = "I" + Integer.toString(inputCont);
        inputCont = Integer.;
        input2 = "I" + Integer.toString(inputCont);
        inputCont ++;
        output = "O" + outputCont;
        outputCont ++;
    }

    @Override
    public String getInput1ID() {
        return input1;
    }

    @Override
    public String getInput2ID() {
        return input2;
    }

    @Override
    public String getOutputID() {
        return output;
    }

    @Override
    public String getInput1() {
        return input1;
    }
}
