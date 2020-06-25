public class ZeroMatrix {
    int[][] matrix;

    public ZeroMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void setZeros() {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        // identify zeros and fill row & col arrays
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // set zeros for rows
        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                for (int j = 0; j < col.length; j++)
                    matrix[i][j] = 0;
            }
        }

        // set zeros for columns
        for (int j = 0; j < col.length; j++) {
            if (col[j]) {
                for (int i = 0; i < row.length; i++)
                    matrix[i][j] = 0;
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, 
                        {4, 5, 0},
                        {7, 8, 9}};
        
        ZeroMatrix zm = new ZeroMatrix(matrix);
        zm.printMatrix();
        zm.setZeros();
        System.out.println();
        zm.printMatrix();
    }
}