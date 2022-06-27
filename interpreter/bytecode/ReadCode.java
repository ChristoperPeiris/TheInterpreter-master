package interpreter.bytecode;

import  interpreter.VirtualMachine;

import java.util.ArrayList;

import java.util.Scanner;

public class ReadCode extends ByteCode {

    private Scanner input = new Scanner(System.in);

    @Override
    public void initialization(ArrayList<String> args){

    }
    @Override
    public void execute(VirtualMachine virtual){
        System.out.println("Enter a number: ");
        int input = this.input.nextInt();
        System.out.println("READ: " + input);
    }

    @Override
    public String toString(){
        return "READ";
    }
}
