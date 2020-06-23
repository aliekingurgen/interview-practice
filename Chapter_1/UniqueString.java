public class UniqueString {
    String s;

    public UniqueString(String str) {
        s = str;
    }

    public boolean isUniqueChars() {
        
        if (s.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (char_set[c])
                return false;
            char_set[c] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        
        UniqueString us = new UniqueString(args[0]);
        System.out.println(us.isUniqueChars());
    }
}