package Logica;

public class GateFactory extends AbstractFactory{
    public GateInterface getGate (String gate){
        if (gate == null){
            return null;
        }

        if (gate.equalsIgnoreCase("AND")){
            return new AndGate();
        }

        return null;
    }

}


