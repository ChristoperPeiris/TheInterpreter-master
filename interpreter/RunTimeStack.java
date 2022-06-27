package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        framePointer.add(0);
    }

    public void dump(){
        Iterator<Integer> itr = framePointer.iterator();
        int next;
        int current = itr.next();
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < framePointer.size(); i++) {
            if (itr.hasNext()){
                next = itr.next();
            } else{
                next = runTimeStack.size();
            }
            output.append("[");
            for(int j = current; j < next; j++) {
                System.out.print(runTimeStack.get(j));
                if(j != next - 1) {
                    System.out.print(",");
                }
            }
            output.append("]");
            current = next;
        }
            System.out.println(output);
    }

    public int pop(){
        if(!runTimeStack.isEmpty()) {
            return runTimeStack.remove(runTimeStack.size() - 1);
        }
        return 0;
    }

    public int push(int index){
        runTimeStack.add(index);
        return index;
    }

    public void newFrameAt(int offsetFromTopOfRunStack){
        framePointer.push(runTimeStack.size() - offsetFromTopOfRunStack);
    }

    public void popFrame(){
        int temp = peek();
        int frameP = framePointer.pop();
        while(runTimeStack.size() >= frameP){
            pop();
        }
        this.push(temp);
    }

    public int peek() {
        if(!runTimeStack.isEmpty()) {
            runTimeStack.get(runTimeStack.size() - 1);
        }
        return 0;
    }

    public int load(int offsetFromFramePointer){
        int x = runTimeStack.get(framePointer.peek() - offsetFromFramePointer);
        push(x);
        return x;
    }

    public int store(int offsetFromFramePointer){
        int i = pop();
        runTimeStack.add(framePointer.peek() - offsetFromFramePointer, i);
        return i;
    }
}
