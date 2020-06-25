public class CheckBalanced {
    private int checkHeight(TreeNode<Integer> root) {
        if (root == null) return 0;

        // Check is left is balanced
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) return -1;

        // Check is right is balanced
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) return -1;

        // Check if the current node is balanced
        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) return -1;
        else return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (checkHeight(root) == -1) return false;
        else return true;
    }
}