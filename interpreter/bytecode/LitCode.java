package interpreter.bytecode;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {

    private int val;
    private String id;

    @Override
    public void initialization(ArrayList<String> arguments) {
        val = Integer.parseInt(arguments.get(0));
        if (arguments.size() > 1) {
            id = arguments.get(1);
        } else {
            id = "";
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        if (id.equals("")) {
            virtualMachine.pushRuntimeStack(val);
        } else {
            virtualMachine.push(0);
        }
    }

    @Override
    public String toString(){
        return "LIT: " + val;
    }
}
