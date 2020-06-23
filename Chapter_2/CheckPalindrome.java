import java.util.Stack;

public class CheckPalindrome {
    LinkedList<Character> list;

    public CheckPalindrome() {
        list = new LinkedList<Character>();
        list.addFirst('A');
        list.addFirst('B');
        list.addFirst('C');
        list.addFirst('D');
        list.addFirst('C');
        list.addFirst('B');
        list.addFirst('A');
    }

    public boolean isPalindrome() {
        Stack<Character> stack = new Stack<Character>();

        Node<Character> pSlow = list.first;
        Node<Character> pFast = list.first;

        boolean isOdd = true;
        while (true) {
            stack.push(pSlow.data);
            pSlow = pSlow.next;
            if (pFast.next == null)
                break;
            else if (pFast.next.next == null) {
                isOdd = false;
                break;
            }
            pFast = pFast.next.next;
        }
        
        if (isOdd)
            stack.pop();

        while (pSlow != null) {    
            if (pSlow.data != stack.pop().charValue()) {
                return false;
            }
            pSlow = pSlow.next;
        }
        
        return true;
    }

    public static void main(String[] args) {
        CheckPalindrome cp = new CheckPalindrome();
        cp.list.printList();
        System.out.println(cp.isPalindrome());

    }
}