public class SortStack {
    Stack<Integer> s;

    public SortStack(Stack<Integer> s) {
        this.s = s;
    }

    Stack<Integer> sort() {
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty()) {
            int tmp = s.pop();
            while (!r.isEmpty() && r.peek() > tmp)
                s.push(r.pop());
            r.push(tmp);
        }
        return r;
    }

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<Integer>();
        for (String arg : args) {
            s.push(Integer.parseInt(arg));
        }

        SortStack ss = new SortStack(s);
        Stack<Integer> sorted = ss.sort();
        while (!sorted.isEmpty()) {
            System.out.print(sorted.pop() + " ");
        }
    }
}