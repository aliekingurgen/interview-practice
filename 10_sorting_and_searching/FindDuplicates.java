import java.util.BitSet;

public class FindDuplicates {

    public void findDuplicates(int[] array) {
        BitSet bs = new BitSet(32000);
        
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num -1; // bitset starts at 0, numbers start at 1
            if (bs.get(num0) == true)
                System.out.println(num);
            else
                bs.set(num0);
        }

    }
}