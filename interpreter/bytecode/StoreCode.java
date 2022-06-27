package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class StoreCode extends ByteCode{

    private int offsetValue;

    @Override
    public void initialization(ArrayList<String> arguments){
        this.offsetValue = Integer.parseInt(arguments.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine){
        virtualMachine.storeRuntimeStack(offsetValue);
    }

    @Override
    public String toString(){
        return "STORE: " + offsetValue;
    }

}
