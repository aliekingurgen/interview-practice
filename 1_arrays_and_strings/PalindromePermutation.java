public class PalindromePermutation {
    String str;

    public PalindromePermutation(String str) {
        this.str = str.toLowerCase();
    }

    public boolean isPalindromePermutation() {
        int[] charCounts = new int[128];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ')
                charCounts[c]++;
        }

        int oddCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charCounts[c] % 2 != 0)
                oddCount++;
            if (oddCount > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePermutation pp = new PalindromePermutation(args[0]);

        System.out.println(pp.isPalindromePermutation());
    }
}