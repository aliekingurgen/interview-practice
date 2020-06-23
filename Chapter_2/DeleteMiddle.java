public class DeleteMiddle {
    LinkedList<Integer> list;
    Node<Integer> middle;

    public DeleteMiddle() {
        list = new LinkedList<Integer>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);
        list.addFirst(7);
        middle = list.first.next.next.next;
    }

    public void deleteMiddleNode() {
        Node<Integer> next = middle.next;
        middle.data = next.data;
        middle.next = middle.next.next;
    }

    public static void main(String[] args) {
        DeleteMiddle dm = new DeleteMiddle();
        dm.list.printList();
        dm.deleteMiddleNode();
        dm.list.printList();
    }
}