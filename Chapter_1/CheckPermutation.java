public class CheckPermutation {
    String s;
    String t;

    public CheckPermutation(String s, String t) {
        this.s = s;
        this.t = t;
    }

    private String sort(String str) {
        char[] str_array = str.toCharArray();
        java.util.Arrays.sort(str_array);
        return new String(str_array);
    }

    public boolean isPermutationSorting() {
        if (s.length() != t.length()) return false;
        return sort(s).equals(sort(t));
    }

    public boolean isPermutationCounting() {

        if (s.length() != t.length()) return false;

        int[] char_set = new int[128];

        char[] s_array = s.toCharArray();
        for (char c : s_array)
            char_set[c]++;
        
        char[] t_array = t.toCharArray();
        for(char c : t_array) {
            char_set[c]--;
            if (char_set[c] < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CheckPermutation cp = new CheckPermutation(args[0], args[1]);

        System.out.println(cp.isPermutationCounting());
        System.out.println(cp.isPermutationSorting());
    }
}