package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class FalseBranchCode extends ConnectCode {

    private String label = "";
    private int value;
    private int targetAddress;

    @Override
    public void initialization(ArrayList<String> args){
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtual){
        value = virtual.popRuntimeStack();
        if(value == 0){
            virtual.setProgramCounter(targetAddress - 1);
        }
    }

    @Override
    public int getTargetAddress(){
        return targetAddress;
    }

    @Override
    public void setTargetAddress(int targetAddress) {
        this.targetAddress = targetAddress;
    }

    @Override
    public String getLabel(){
        return label;
    }

    @Override
    public String toString(){
        return "FALSE : " + label;
    }
}
