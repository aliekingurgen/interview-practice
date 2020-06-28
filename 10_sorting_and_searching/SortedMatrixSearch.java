import javax.lang.model.util.ElementScanner6;

public class SortedMatrixSearch {
    public boolean search(int[][] matrix, int x) {
        int row = 0;
        int col = matrix[0].length -1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == x)
                return true;
            else if (matrix[row][col] > x)
                col--;
            else
                row++;
        }
        return false;
    }
}