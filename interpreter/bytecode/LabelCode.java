package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode{
    private String label;

    @Override
    public void initialization(ArrayList<String> arguments){
        this.label = arguments.get(0);
    }

    @Override
    public void execute(VirtualMachine virtual){

    }

    @Override
    public String toString(){
        return "LABEL NAME: " + label;
    }

    public String getLabel(){
        return label;
    }
}
