package Logica;

public class GateFactory implements GateInterface{

    @Override
    public Object createGate (String type) {

        if(type == "and"){
            return new AndGate(2);
        }

        if (type == "or") {
            return new OrGate(2);
        }

        if (type == "xor") {
            return new XorGate();
        }

        /*if (type == "xnor") {
        }

        if (type == "nand") {
        }
        if (type == "nor") {
        }
        if (type == "xnor") {
        }*/

        return false;

    }

}


