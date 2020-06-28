public class SearchArrayNoSize {
    private int binarySearch(Listy a, int x, int lo, int hi) {
        int mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            int middle = a.elementAt(mid);
            if (x < middle || middle == -1)
                hi = mid - 1;
            else if (x > middle)
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public int search(Listy a, int x) {
        if (a.elementAt(0) == -1)
            return 0;

        int i = 1;
        while (a.elementAt(i) != -1 && a.elementAt(i) < x)
            i *= 2;
        return binarySearch(a, x, i / 2, i);
    }
}