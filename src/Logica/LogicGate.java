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
    public boolean output = false;

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

    /**
     * Crea una conexión lógica interna entre compuertas.
     * Cada compuerta internamente posee una lista llamada conexiones,
     * la compuerta que transmite se añadirá a la lista de conexiones
     * de la compuerta que recibe.
     * @param receiverGate
     */
    public void connection(LogicGate receiverGate){
        receiverGate.connections.lastInsert(this);
    }

    public void value(LogicGate receiverGate){
        receiverGate.inputs.lastInsert(this.output);
    }

}
