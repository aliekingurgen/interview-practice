public class Intersection {
    LinkedList<Character> list1;
    LinkedList<Character> list2;

    public Intersection() {
        list1 = new LinkedList<Character>();
        list2 = new LinkedList<Character>();
        list1.addFirst('A');
        list1.addFirst('B');
        list2.addFirst('C');
        list2.addFirst('D');

        Node<Character> commonNode1 = new Node<Character>('E');
        Node<Character> commonNode2 = new Node<Character>('F');
        list1.first.next.next = commonNode1;
        list2.first.next.next = commonNode1;
        commonNode1.next = commonNode2;
    }

    private Node<Character> returnIntersection() {
        Node<Character> n1 = list1.first;
        Node<Character> n2 = list2.first;

        if (n1 == null || n2 == null)
            return null;

        int n1Length = 1;
        while (n1.next != null) {
            n1 = n1.next;
            n1Length++;
        }

        int n2Length = 1;
        while (n2.next != null) {
            n2 = n2.next;
            n2Length++;
        }

        if (n1 != n2)
            return null;
        
        int sizeDiff = n1Length - n2Length;

        if (sizeDiff > 0) {
            Node<Character> curr = list1.first;
            while (sizeDiff > 0 && curr != null) {
                curr = curr.next;
                sizeDiff--;
            }
            n2 = list2.first;
            while (curr != n2) {
                curr = curr.next;
                n2 = n2.next;
            }
            return curr;
        }

        else {
            Node<Character> curr = list2.first;
            while (sizeDiff > 0 && curr != null) {
                curr = curr.next;
                sizeDiff--;
            }
            n1 = list1.first;
            while (curr != n1) {
                curr = curr.next;
                n1 = n1.next;
            }
            return curr;
        }
    }

    public static void main(String[] args) {
        Intersection is = new Intersection();
        is.list1.printList();
        is.list2.printList();
        System.out.println(is.returnIntersection().data);
    }
}