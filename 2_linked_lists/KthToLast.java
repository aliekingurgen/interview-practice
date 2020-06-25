import java.util.HashMap;

public class KthToLast {
    LinkedList<Integer> list;
    int k;

    public KthToLast(int k) {
        this.k = k;
        list = new LinkedList<Integer>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(4);
        list.addFirst(2);
        list.addFirst(5);
        list.addFirst(6);
    }

    public int returnKthToLastMyApproach() {
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();

        Node<Integer> n = list.first;
        int index = 0;
        while (n != null) {
            table.put(index, n.data);
            n = n.next;
            index++;
        }

        int ktlIndex = index - k;

        return table.get(ktlIndex);
    }

    public Node<Integer> returnKthToLastBookSoln() {
        Node<Integer> p1 = list.first;
        Node<Integer> p2 = list.first;

        for (int i = 0; i < k; i++)
            p1 = p1.next;
        
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        KthToLast ktl = new KthToLast(k);
        
        System.out.println(ktl.returnKthToLastMyApproach());
        System.out.println((ktl.returnKthToLastBookSoln()).data);
    }
}