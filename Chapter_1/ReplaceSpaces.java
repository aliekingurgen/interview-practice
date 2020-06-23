public class ReplaceSpaces {
    char[] str;
    int trueLength;

    public ReplaceSpaces(char[] str, int length) {
        this.str = str;
        this.trueLength = length;
    }

    public void replaceSpaces() {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ')
                spaceCount++;
        }

        int newLength = trueLength + spaceCount * 2;
        // str[newLength] = '\0';
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength -= 3;
            }
            else {
                str[newLength - 1] = str[i];
                newLength -= 1;
            }
        }
    }

    public static void main(String[] args) {
        char[] str_array = args[0].toCharArray();
        int length = Integer.parseInt(args[1]);

        ReplaceSpaces rs = new ReplaceSpaces(str_array, length);
        rs.replaceSpaces();
        System.out.println(rs.str);
    }
}