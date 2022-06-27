package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runTimeStack;
    private Stack<Integer> returnAddress;
    private Program program;
    private int programCounter;
    private boolean isRunning;
    private boolean dump = false;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram(){
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<>();
        isRunning = true;

        do {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            if(dump){
                System.out.println(code);
                runTimeStack.dump();
            }
            programCounter = programCounter + 1;
        } while (isRunning);

    }

    public int popReturnAddress(){
        return returnAddress.pop();
    }

    public void newFrameAt(int offset){
        runTimeStack.newFrameAt(offset);
    }

    public void popFrameAt(){
        runTimeStack.popFrame();
    }

    public int popRuntimeStack(){
        return runTimeStack.pop();
    }

    public void pushReturnAddress(){
        returnAddress.push(programCounter);
    }

    public int peekRuntimeStack(){
        return runTimeStack.peek();
    }

    public void pushRuntimeStack(Integer i) {
        runTimeStack.push(i);
    }

    public void loadRuntimeStack(int i){
        runTimeStack.load(i);
    }

    public void storeRuntimeStack(int i){
        runTimeStack.load(i);
    }

    public void push(int num){
        runTimeStack.push(num);
    }

    public void setProgramCounter(int programCounter){
        this.programCounter = programCounter;
    }

    public void setDump(boolean dump){
        this.dump = dump;
    }

    public boolean isRunningFalse(){
        return false;
    }
}

