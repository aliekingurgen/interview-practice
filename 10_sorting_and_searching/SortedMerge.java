public class SortedMerge {
    public void mergeArrays(int[] A, int[] B, int numA, int numB) {
        
        int indexA = numA - 1;
        int indexB = numB - 1;
        int indexMerged = numA + numB - 1;

        while (indexB >= 0) {
            if (A[indexA] > B[indexB] && indexA >= 0) {
                A[indexMerged] = A[indexA];
                indexA--;
            }
            else {
                A[indexMerged] = B[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }
}