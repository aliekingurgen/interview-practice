public class Partition {
    LinkedList<Integer> list;
    int partVal;

    public Partition(int d) {
        list = new LinkedList<Integer>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(10);
        list.addFirst(5);
        list.addFirst(8);
        list.addFirst(5);
        list.addFirst(3);
        partVal = d;
    }

    public void partitionList() {
        Node<Integer> n = list.first;

        while(n.next != null) {
            if (n.next.data < partVal) {
                Node<Integer> oldFirst = list.first;
                list.first = new Node<Integer>(n.next.data);
                list.first.next = oldFirst;
                n.next = n.next.next;
            }
            else
                n = n.next;
        }
        if (n.data < partVal) {
            Node<Integer> oldFirst = list.first;
            list.first = new Node<Integer>(n.data);
            list.first.next = oldFirst;
            n.next = n.next.next;
        }
    }

    public static void main(String[] args) {
        Partition p = new Partition(Integer.parseInt(args[0]));
        p.list.printList();
        p.partitionList();
        p.list.printList();
    }
}