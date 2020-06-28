import javax.lang.model.util.ElementScanner6;

public class SparseSearch {
    private int search(String[] array, String str, int lo, int hi) {
        
        int mid = lo + (hi - lo) / 2;
        if (array[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < lo && right > hi) {
                    return -1;
                }
                else if (!array[left].isEmpty()) {
                    mid = left;
                    break;
                }
                else if (!array[right].isEmpty()) {
                    mid = right;
                    break;
                }
                left--;
                right++;
            }
        }

        if (array[mid].compareTo(str) > 0)
            return search(array, str, lo, mid - 1);
        if (array[mid].compareTo(str) < 0)
            return search(array, str, mid + 1, hi);
        else
            return mid;
    }

    public int search(String[] array, String str) {
        return search(array, str, 0, array.length - 1);
    }
}