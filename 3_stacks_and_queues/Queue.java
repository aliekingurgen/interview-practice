import java.util.NoSuchElementException;

public class Queue<Item> {
    private QueueNode<Item> first;
    private QueueNode<Item> last;

    private static class QueueNode<Item> {
        private Item data;
        private QueueNode<Item> next;

        public QueueNode(Item data) {
            this.data = data;
        }
    }

    public void add(Item data) {
        QueueNode<Item> newNode = new QueueNode<Item>(data);
        if (last != null)
            last.next = newNode;

        last = newNode;

        if (first == null)
            first = last;
    }

    public Item remove() {
        if (first == null) throw new NoSuchElementException();

        Item data = first.data;
        first = first.next;

        if (first == null)
            last = null;

        return data;
    }

    public Item peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return (first == null);
    }
}