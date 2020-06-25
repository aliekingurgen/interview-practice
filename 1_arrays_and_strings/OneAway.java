public class OneAway {
    String s;
    String t;

    public OneAway(String s, String t) {
        this.s = s.toLowerCase();
        this.t = t.toLowerCase();
    }

    public boolean isOneAway() {
        int lengthDiff = s.length() - t.length();
        if (Math.abs(lengthDiff) > 1) return false;

        if (lengthDiff == 0) {
            int awayCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i))
                    awayCount++;
                if (awayCount > 1)
                    return false;
            }
        }

        else if (lengthDiff > 0) {
            int awayCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (awayCount == 0 && i == s.length() - 1)
                    return true;
                if (s.charAt(i) != t.charAt(i - awayCount))
                    awayCount++;
                if (awayCount > 1)
                    return false;
            }
        }

        else if (lengthDiff < 0) {
            int awayCount = 0;
            for (int i = 0; i < t.length(); i++) {
                if (awayCount == 0 && i == t.length() - 1)
                    return true;
                if (s.charAt(i - awayCount) != t.charAt(i))
                    awayCount++;
                if (awayCount > 1)
                    return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        OneAway oa = new OneAway(args[0], args[1]);
        System.out.println(oa.isOneAway());
    }
}