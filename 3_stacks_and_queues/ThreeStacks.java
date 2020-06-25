import java.util.EmptyStackException;
// import java.util.FullStackException;

public class ThreeStacks {
    private int stackCapacity;
    private int[] values;
    private int[] stackSizes;

    public ThreeStacks(int stackSize) {
        stackCapacity = stackSize;
        values = new int[3 * stackSize];
        stackSizes = new int[3];
    }

    public void push(int stackNum, int value) {
        if (stackSizes[stackNum] == stackCapacity)
            System.out.println("Stack is full!");
        stackSizes[stackNum]++;
        values[indexOfStackTop(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (stackSizes[stackNum] == 0)
            throw new EmptyStackException();
        int value = values[indexOfStackTop(stackNum)];
        values[indexOfStackTop(stackNum)] = 0;
        stackSizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        if (stackSizes[stackNum] == 0)
            throw new EmptyStackException();
        return values[indexOfStackTop(stackNum)];
    }

    private int indexOfStackTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        return offset + stackSizes[stackNum] - 1;
    }

    public void printArray() {
        for (int i : values)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        ThreeStacks ts = new ThreeStacks(3);
        ts.printArray();
        ts.push(0, 100);
        ts.push(1, 200);
        ts.push(2, 300);
        ts.printArray();
        ts.push(1, 2000);
        ts.printArray();
        ts.pop(2);
        ts.printArray();
        ts.pop(1);
        ts.pop(1);
        ts.printArray();
        ts.pop(0);
        ts.printArray();
    }
}