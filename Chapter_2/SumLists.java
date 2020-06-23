public class SumLists {
    LinkedList<Integer> list1;
    LinkedList<Integer> list2;
    LinkedList<Integer> list3;
    LinkedList<Integer> list4;

    public SumLists() {
        list1 = new LinkedList<Integer>();
        list1.addFirst(6);
        list1.addFirst(1);
        list1.addFirst(7);
        list1.addFirst(1);

        list2 = new LinkedList<Integer>();
        list2.addFirst(2);
        list2.addFirst(9);
        list2.addFirst(5);

        list3 = new LinkedList<Integer>();
        list3.addFirst(7);
        list3.addFirst(1);
        list3.addFirst(6);

        list4 = new LinkedList<Integer>();
        list4.addFirst(5);
        list4.addFirst(9);
        list4.addFirst(2);
    }

    public LinkedList<Integer> sumListsReverse() {

        LinkedList<Integer> sum = new LinkedList<Integer>();
        sum.first = new Node<Integer>(0);
        Node<Integer> nSum = sum.first;

        Node<Integer> n1 = list1.first;
        Node<Integer> n2 = list2.first;

        if (n1 == null) return list1;
        if (n2 == null) return list2;

        int carryOver = 0;
        while (n1 != null && n2 != null) {
            nSum.data = (n1.data + n2.data + carryOver) % 10;
            carryOver = (n1.data + n2.data + carryOver) / 10;
            n1 = n1.next;
            n2 = n2.next;
            if (n1 == null && n2 == null) break;
            else {
                nSum.next = new Node<Integer>(0);
                nSum = nSum.next;
            }
            if (n1 == null) n1 = new Node<Integer>(0);
            if (n2 == null) n2 = new Node<Integer>(0);
        }
        return sum;
    }

    public static void main(String[] args) {
        SumLists sl = new SumLists();
        sl.list1.printList();
        sl.list2.printList();
        sl.sumListsReverse().printList();
    }
}