package Logica;

import Estructuras.LinkedLists;

public class LogicGate {
    private int inputCont;
    private int outputCont;
    public String inputID;
    public String outputID;
    public LinkedLists inputs = new LinkedLists();
    public LogicGate output = null;
    public boolean value = false;
    public LinkedLists connectionList = new LinkedLists();

    public LogicGate(){
        inputCont = 0;
        outputCont = 0;
        inputID = "I" + Integer.toString(inputCont) ;
        inputCont ++;
        inputs.insert();
        outputID = "O" + Integer.toString(outputCont);
        outputCont ++;
    }

    public void connection(LogicGate connectedIn, LogicGate connectedOut){
        if (connectedIn);
        LinkedLists link = new LinkedLists();
        link.insert(connectedOut.outputID);
        link.insert(connectedIn.);
        connectionList.insert(link);

        LogicGate comp1 = new LogicGate();
        LogicGate comp2 = new LogicGate();

        comp1.output = connectedOut;
        if (connectedIn. )

    }

    /*
    public void movement(){

    }

    public boolean value(){

    }

    public String showList(){

    }
    */
}
