public class LinkedList<Item> {
    Node<Item> first;
    private int numOfItems;

    public LinkedList() {
        numOfItems = 0;
        first = null;
    }

    public void addFirst(Item item) {
        if (item == null)
            throw new NullPointerException("Item cannot be null");

        Node<Item> oldFirst = first;
        first = new Node<Item>(item);
        first.next = oldFirst;

        numOfItems++;
    }

    public boolean deleteItem(Item item) {
        if (item == null)
            throw new NullPointerException("Item cannot be null");

        Node<Item> n = first;
        if (n.data == item) {
            first = first.next;
            return true;
        }

        while (n.next != null) {
            if (n.next.data == item) {
                n.next = n.next.next;
                return true;
            }
            n = n.next;
        }
        return false;
    }

    public void printList() {
        Node<Item> n = first;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<Integer>();
        myList.addFirst(1);
        myList.addFirst(2);
        myList.addFirst(3);
        myList.addFirst(4);
        myList.printList();

        myList.deleteItem(2);
        myList.printList();
        myList.deleteItem(4);
        myList.printList();
        myList.deleteItem(1);
        myList.printList();
        myList.deleteItem(5);
        myList.printList();
    }
}