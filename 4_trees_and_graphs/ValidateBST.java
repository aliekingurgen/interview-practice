public class ValidateBST {
    private boolean checkNode(TreeNode<Integer> node, int min, int max) {
        if (node == null) return true;
        
        if (node.value <= min || node.value > max) return false;

        if (!checkNode(node.left, min, node.value) || !checkNode(node.right, node.value, max)) return false;
        
        return true;
    }

    public boolean checkBST(TreeNode<Integer> root) {
        int minLimit = Integer.MIN_VALUE;
        int maxLimit = Integer.MAX_VALUE;
        return checkNode(root, minLimit, maxLimit);
    }
}