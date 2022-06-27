package interpreter.bytecode;

import java.util.ArrayList;

import interpreter.VirtualMachine;

public abstract class ConnectCode extends ByteCode{
    public abstract void initialization(ArrayList<String> arguments);
    public abstract void execute(VirtualMachine virtualMachine);
    public abstract int getTargetAddress();
    public abstract void setTargetAddress(int targetAddress);
    public abstract String getLabel();
}
