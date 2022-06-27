package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class HaltCode extends ByteCode{


    @Override
    public void initialization(ArrayList<String> arguments){}

    @Override
    public void execute(VirtualMachine virtualMachine){
        virtualMachine.isRunningFalse();
    }

    @Override
    public String toString(){
        return "HALT";
    }

}
