public class RotateMatrix {
    int[][] image;

    public RotateMatrix(int[][] matrix) {
        this.image = matrix;
    }

    public void rotate() {
        if (image.length == 0 || image.length != image[0].length)
            System.err.println("Input matrix is not valid.");

            int n = image.length;
            for (int layer = 0; layer < n/2; layer++) {

                int first = layer;
                int last = n - 1 - layer;

                for (int i = first; i < last; i++) {
                    int offset = i - first;
                    int top = image[first][i]; // save the top
                    image[first][i] = image[last-offset][first]; // left -> top
                    image[last-offset][first] = image[last][last-offset]; // bottom -> left
                    image[last][last-offset] = image[i][last]; // right -> bottom
                    image[i][last] = top; // top -> right
                }
            }
    }

    public void printMatrix() {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image.length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, 
                        {4, 5, 6},
                        {7, 8, 9}};
        
        RotateMatrix rm = new RotateMatrix(matrix);
        rm.printMatrix();
        rm.rotate();
        System.out.println();
        rm.printMatrix();
    }
}