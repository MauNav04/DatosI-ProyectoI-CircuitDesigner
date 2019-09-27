package Logica;

import Estructuras.LinkedLists;
import Estructuras.Node;

public class AndGate extends LogicGate {

    public AndGate(int inputAmount) {
        super(inputAmount);
        if (this.validInputs(inputAmount) == true){
            calculateOut();
        }
        System.out.println("WTF !!!!!!");
    }

    public void calculateOut(){
        for(int i = 0; i < this.inputs.getSize(); i++){
            boolean value = (boolean) this.inputs.get(i);
            if(value == false){
                if (i == this.inputs.getSize()-1 ){
                    this.output = false;
                    break;
                }
            }
            else if(value == true){
                this.output = true;
            }
            else{
                System.out.println("Se ha encontrado una compuerta sin valor de salida");
                break;
            }
        }

    }

}
