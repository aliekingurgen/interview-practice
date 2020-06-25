import java.util.EmptyStackException;

public class Stack<Item> {
    private StackNode<Item> top;

    private static class StackNode<Item> {
        private Item data;
        private StackNode<Item> next;

        public StackNode(Item data) {
            this.data = data;
        } 
    }

    public Item pop() {
        if (top == null) throw new EmptyStackException();

        Item data = top.data;
        top = top.next;
        return data;
    }

    public void push(Item data) {
        StackNode<Item> newNode = new StackNode<Item>(data);
        newNode.next = top;
        top = newNode;
    }

    public Item peek() {
        if (top == null) throw new EmptyStackException();

        return top.data;
    }

    public int size() {
        if (top == null) return 0;

        int size = 1;
        StackNode<Item> curr = this.top;

        while (curr.next != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void printStack() {
        
    }
}