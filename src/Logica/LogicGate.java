package Logica;

import Estructuras.LinkedLists;

public class LogicGate {
    private static int inputCont;
    private static int outputCont;
    public static int gateCont = 0;
    public String gateID;
    public String inputID="";
    public String outputID="";
    public LinkedLists connections = new LinkedLists();
    public LinkedLists inputs = new LinkedLists();
    public boolean output;

    public LogicGate(int inputAmount){
        gateID = "G" + Integer.toString(this.gateCont);
        this.gateCont ++;
        for(int i = 0; i < inputAmount; i++){
            inputID = "I" + Integer.toString(inputCont) ;
            this.inputCont ++;

            LinkedLists inputInfo = new LinkedLists();
            inputInfo.lastInsert(false);
            inputInfo.lastInsert(inputID);
            inputs.insert(inputInfo);
        }
        outputID = "O" + Integer.toString(outputCont);
        this.outputCont ++;

    }

    public void connection(LogicGate receiverGate, int inputAmount){
        receiverGate.connections.lastInsert(this);
    }

    public void connectValue(LogicGate receiverGate){
        receiverGate.inputs.lastInsert(this.output);
    }

    public boolean getValue(){
        return this.output;
    }

    public void setValue(boolean value){
        this.output = value;
    }

    public boolean validInputs(int inputAmout){
        System.out.println("INPUTS" + inputs.getSize());
        if (inputs.getSize() == inputAmout){
            return true;
        }
        else{return  false;}
    }

    /*
    public void movement(){

    }


    public String showList(){

    }
    */
}
