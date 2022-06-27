package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class PopCode extends ByteCode {

    private int numValToRemove;

    @Override
    public void initialization(ArrayList<String> virtualMachine){
         numValToRemove = Integer.parseInt(virtualMachine.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine){
        for(int j = 0; j < numValToRemove; numValToRemove++){
            virtualMachine.popReturnAddress();
        }
    }

    @Override
    public String toString(){
        return "POP: " + numValToRemove;
    }
}
