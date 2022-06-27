package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class BopCode extends ByteCode {

    private String operator;
    @Override
    public void initialization(ArrayList<String> args){
        operator = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtual){
        int operator1 = virtual.popRuntimeStack();
        int operator2 = virtual.popRuntimeStack();

        switch(operator){
            case "+":
                virtual.pushRuntimeStack(operator1 + operator2);
                break;
            case "-":
                virtual.pushRuntimeStack(operator1 - operator2);
                break;
            case "*":
                virtual.pushRuntimeStack(operator1 * operator2);
                break;
            case "/":
                virtual.pushRuntimeStack(operator1 / operator2);
                break;
            case "==":
                if(operator1 == operator2){
                    virtual.pushRuntimeStack(1);
                }else{
                    virtual.pushRuntimeStack(0);
                }
                break;
            case "!=":
                if (operator1 != operator2){
                    virtual.pushRuntimeStack(1);
                }else{
                    virtual.pushRuntimeStack(0);
                }
                break;
            case "<=":
                if (operator1 <= operator2){
                    virtual.pushRuntimeStack(1);
                }else{
                    virtual.pushRuntimeStack(0);
                }
                break;
            case ">=":
                if (operator1 >= operator2){
                    virtual.pushRuntimeStack(1);
                }else {
                    virtual.pushRuntimeStack(0);
                }
                break;
            case ">":
                if (operator1 > operator2){
                    virtual.pushRuntimeStack(1);
                }else{
                    virtual.pushRuntimeStack(0);
                }
                break;
            case "<":
                if (operator1 < operator2){
                    virtual.pushRuntimeStack(1);
                }else{
                    virtual.pushRuntimeStack(0);
                }
                break;
            default:
                virtual.pushRuntimeStack(0);
        }
    }
    @Override
    public String toString() {
        return "BOP : " + operator;
    }
}
