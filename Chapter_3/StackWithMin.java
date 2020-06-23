import java.util.EmptyStackException;

public class StackWithMin extends Stack<Integer> {
    Stack<Integer> stack2; // extra stack that has the smallest item at the top at all tim

    public StackWithMin() {
        stack2 = new Stack<Integer>();
    }

    public void push(int value) {
        if (value <= min())
            stack2.push(value);
        super.push(value);
    }

    public Integer pop() {
        if (stack2.isEmpty())
            throw new EmptyStackException();

        int value = super.pop();
        if (value == min())
            stack2.pop();
        
        return value;
    }

    public int min() {
        if (stack2.isEmpty()) 
            return Integer.MAX_VALUE;
        else
            return stack2.peek();
    }


    public static void main(String[] args) {
        StackWithMin swm = new StackWithMin();
        swm.push(5);
        System.out.println("min: " + swm.min());
        swm.push(6);
        System.out.println("min: " + swm.min());
        swm.push(3);
        System.out.println("min: " + swm.min());
        swm.push(7);
        System.out.println("min: " + swm.min());
        swm.pop();
        System.out.println("min: " + swm.min());
        swm.pop();
        System.out.println("min: " + swm.min());
    }
}