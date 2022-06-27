package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.ConnectCode;
import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Program {

    static HashMap<String, Integer> codeLabels;
    private List<ByteCode> program;
    private int i = 1;

    public Program() {
        program = new ArrayList<>();
        codeLabels = new HashMap<>();
    }

    public ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    public void addCode(ByteCode bytecode) {
        if(bytecode instanceof LabelCode) {
            LabelCode branchLabel = (LabelCode)bytecode;
            codeLabels.put(branchLabel.getLabel(), program.size());
        }
        program.add(bytecode);
    }

    public void resolveAddress() {
        for(ByteCode byteCode : program){
            if(byteCode instanceof ConnectCode){
                String label = ((ConnectCode) byteCode).getLabel();
                int index = codeLabels.get(label);
                ((ConnectCode) byteCode).setTargetAddress(index);
            }
        }
    }
}
