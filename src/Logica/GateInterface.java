package Logica;

import java.io.*;

interface GateInterface {
    public int inputCont = 0;
    public int outputCont = 0;

    String getInput1ID();
    String getInput2ID();
    String getOutputID();
    Boolean getInput1();
    Boolean getInput2();
    Boolean getOutput();
    Void setInput1();
    Void setInput2();
    Void setOutput();
}
