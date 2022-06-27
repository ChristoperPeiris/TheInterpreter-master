package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class DumpCode extends ByteCode{

    private boolean status;
    private String label;

    @Override
    public void initialization(ArrayList<String> arguments){
        this.label = arguments.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine){
        if(label.equals("ON")){
            status = true;
            virtualMachine.setDump(status);
        }else {
            status = false;
            virtualMachine.setDump(status);
        }
        virtualMachine.setDump(status);
    }

    @Override
    public String toString(){
        return "DUMP : " + label;
    }
}
