import java.util.Comparator;
import java.util.Arrays;

public class AnagramComperator implements Comparator<String> {
    public String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public int compare(String s1, String s2) {
        return sortChars(s1).compareTo(sortChars(s2));
    }

    public void groupAnagrams(String[] array) {
        Arrays.sort(array, new AnagramComperator());
    }
}