public class StringRotation {
    String s1;
    String s2;

    public StringRotation(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public boolean isRotation() {
        if (s1.length() != s2.length() || s1.length() == 0)
            return false;
        
        String s1Concat = s1 + s1;
        return s1Concat.contains(s2);
    }

    public static void main(String[] args) {

        StringRotation sr = new StringRotation(args[0], args[1]);
        System.out.println(sr.isRotation());
    }
}