public class LoopDetection {
    LinkedList<Integer> list;

    public LoopDetection() {
        list = new LinkedList<Integer>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.first.next.next.next.next = list.first.next; // loop starts at 3
    }

    public boolean containsLoop() {
        Node<Integer> pSlow = list.first;
        Node<Integer> pFast = list.first.next;

        while (pFast != null) {
            if (pFast == pSlow)
                return true;
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        return false;
    }

    public Node<Integer> findLoop() {
        Node<Integer> pSlow = list.first;
        Node<Integer> pFast = list.first;

        while (pFast != null && pFast.next != null) {
            pSlow = pSlow.next;
            pFast = pFast.next.next;
            if (pFast == pSlow) {
                pSlow = list.first;
                break;
            }
        }

        if (pFast == null || pFast.next == null)
            return null;


        while (pFast != pSlow) {
            pSlow = pSlow.next;
            pFast = pFast.next;
        }
        return pFast;
    }

    public static void main(String[] args) {
        LoopDetection ld = new LoopDetection();
        // System.out.println(ld.containsLoop());
        System.out.println(ld.findLoop().data);
    }
}