package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;
public class ReturnCode extends ByteCode{

    private String function = "";
    private int var;

    @Override
    public void initialization(ArrayList<String> arguments){
            if(!arguments.isEmpty()){
                function = arguments.get(0);
            }
    }

    @Override
    public void execute(VirtualMachine virtualMachine){
        var = virtualMachine.peekRuntimeStack();
        virtualMachine.popFrameAt();
        virtualMachine.setProgramCounter(virtualMachine.popReturnAddress());
        virtualMachine.pushRuntimeStack(var);
    }

    @Override
    public String toString(){
        return "RETURN: " + var;
    }
}
