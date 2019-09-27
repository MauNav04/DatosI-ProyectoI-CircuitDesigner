package Logica;

public class ApplicationF {
    private GateInterface factory;
    private String type;
    private Object gate;

    public ApplicationF(GateInterface factory, String type){
        this.factory = factory;
        this.type = type;
    }

    public Object newGate(){
        this.gate = factory.createGate(type);
        return this.gate;
    }
}
