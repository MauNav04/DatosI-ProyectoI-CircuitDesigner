package Logica;

import Estructuras.LinkedLists;

public class LogicGate {
    private int inputCont;
    private int outputCont;
    public static int gateCont = 0;
    public String gateID;
    public String inputID="";
    public String outputID="";
    public LinkedLists connections = new LinkedLists();
    public LinkedLists inputs = new LinkedLists();
    public boolean output = false;

    public LogicGate(){
        gateID = "G" + Integer.toString(this.gateCont);
        System.out.println("Gate cont:"+ Integer.toString(this.gateCont));
        System.out.println("Gate ID:"+ gateID);
        this.gateCont ++;
        inputID = "I" + Integer.toString(inputCont) ;
        this.inputCont ++;
        inputs.insert(null);
        outputID = "O" + Integer.toString(outputCont);
        this.outputCont ++;
    }

    public void connection(LogicGate receiverGate){
        receiverGate.connections.lastInsert(this);
    }

    public void value(LogicGate receiverGate){
        receiverGate.inputs.lastInsert(this.output);
    }

    /*
    public void movement(){

    }


    public String showList(){

    }
    */
}
