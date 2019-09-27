package Logica;

import Estructuras.LinkedLists;

public class OrGate extends LogicGate {

    public OrGate(int inputAmount) {
        super(inputAmount);
    }

    /*public boolean calculateOut (){
        LinkedLists valueList = new LinkedLists();

        for(int i = 0; i < inputAmount; i++){
            LogicGate currentGate = (LogicGate) receiverGate.connections.get(i);
            if(currentGate.getValue() == false || currentGate.getValue() == true){
                valueList.lastInsert(currentGate.getValue());
                if (i == 2){
                    currentGate.setValue();
                }
            }
            else{
                System.out.println("Se ha encontrado una compuerta sin valor de salida");
                break;
            }
        }
        return
    }*/


}
