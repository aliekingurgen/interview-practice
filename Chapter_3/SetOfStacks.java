import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
    int capacity;
    ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
        Stack<Integer> firstStack = new Stack<Integer>();
        stacks.add(firstStack);
    }

    public void push(int value) {
        Stack<Integer> last = stacks.get(stacks.size() - 1);
        if (last.size() == capacity) {
            Stack<Integer> newStack = new Stack<Integer>();
            newStack.push(value);
            stacks.add(newStack);
        }
        else {
            last.push(value);
        }
    }

    public int pop() {
        Stack<Integer> last = stacks.get(stacks.size() - 1);
        if (last.isEmpty()) throw new EmptyStackException();

        int val = last.pop();
        if (last.size() == 0) stacks.remove(stacks.size() - 1);

        return val;
    }

    public int popAt(int index) {
        Stack<Integer> last = stacks.get(stacks.size() - 1);
        if (last.isEmpty()) throw new EmptyStackException();

        return stacks.get(index).pop();
    }

    public void printSetOfStacks() {
        for (int i = stacks.size() - 1; i >= 0; i--) {
            Stack<Integer> curStack = stacks.get(i);
            while (!curStack.isEmpty()) {
                System.out.print(curStack.pop() + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        SetOfStacks ss = new SetOfStacks(3);
        ss.push(1);
        ss.push(2);
        ss.push(3);
        ss.push(4);
        ss.push(5);
        ss.push(6);
        ss.push(7);
        ss.push(8);
        ss.push(9);
        ss.pop();
        ss.pop();
        ss.pop();
        ss.pop();
        ss.printSetOfStacks();
    }
}