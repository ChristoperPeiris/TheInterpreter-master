package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class CallCode extends ConnectCode{

    private String label = "";
    private int targetAddress;

    @Override
    public void initialization(ArrayList<String> arguments){
        this.label = arguments.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine){
        virtualMachine.pushReturnAddress();
        virtualMachine.setProgramCounter(targetAddress - 1);
    }

    @Override
    public int getTargetAddress(){ return targetAddress; }

    public void setTargetAddress(int targetAddress){
        this.targetAddress = targetAddress;
    }

    public String getLabel(){
        return label;
    }

    @Override
    public String toString(){
        return "CALL : " + label;
    }
}
