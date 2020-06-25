public class StringCompression {
    String str;

    public StringCompression(String str) {
        this.str = str.toLowerCase();
    }

    public String compress() {
        StringBuilder compressedStr = new StringBuilder();

        int runCount = 0;
        for (int i = 0; i < str.length(); i++) {
            runCount++;

            if(i + 1 == str.length() || str.charAt(i + 1) != str.charAt(i)) {
                compressedStr.append(str.charAt(i));
                compressedStr.append(runCount);
                runCount = 0;
            }
        }

        if (compressedStr.length() < str.length())
            return compressedStr.toString();
        else
            return str;
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression(args[0]);
        System.out.println(sc.compress());
    }
}