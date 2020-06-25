public class InOrderSuccessor {
    TreeNode<Integer> getInOrderSuccessor(TreeNode<Integer> n) {
        if (n == null) return null;

        if (n.right != null) {
            while (n.left != null)
                n = n.left;
            return n;
        }

        else {
            TreeNode<Integer> q = n;
            TreeNode<Integer> x = q.parent;
            // Go up until we're on the left instead of right
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }
}