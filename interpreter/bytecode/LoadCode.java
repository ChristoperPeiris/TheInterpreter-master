package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;


public class LoadCode extends ByteCode {

    private int val;
    private String variable;

    @Override
    public void initialization(ArrayList<String> arguments){
        this.val = Integer.parseInt(arguments.get(0));
        variable = arguments.get(1);

    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.loadRuntimeStack(val);
    }

    @Override
    public String toString(){
        return "LOAD: " + val + " " + variable;
    }
}
