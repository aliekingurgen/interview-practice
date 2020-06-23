import java.util.HashSet;

public class RemoveDups {
    LinkedList<Integer> list;

    public RemoveDups() {
        list = new LinkedList<Integer>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(4);
        list.addFirst(2);
        list.addFirst(5);
        list.addFirst(6);
    }

    public void removeDupsWithHT() {
        HashSet<Integer> distinctItems = new HashSet<Integer>();
        Node<Integer> n = list.first;
        Node<Integer> prev = null;

        while (n != null) {
            if (distinctItems.contains(n.data)) {
                prev.next = n.next;
            }
            else {
                distinctItems.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }

    public void removeDupsWithTwoPasses() {
        Node<Integer> curr = list.first;
        
        while (curr != null) {
            Node<Integer> fast = curr;
            while (fast.next != null) {
                if (fast.next.data == curr.data)
                    fast.next = fast.next.next;
                else
                    fast = fast.next;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        RemoveDups rd = new RemoveDups();
        rd.list.printList();
        // rd.removeDupsWithHT();
        rd.removeDupsWithTwoPasses();
        rd.list.printList();
    }
}