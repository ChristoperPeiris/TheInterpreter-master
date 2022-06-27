package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class WriteCode extends ByteCode {

    private int i;

    @Override
    public void initialization(ArrayList<String> args){}

    @Override
    public void execute(VirtualMachine virtual) {
         i = virtual.peekRuntimeStack();
         System.out.println(i);
    }

    @Override
    public String toString(){
        return "WRITE";
    }
}
