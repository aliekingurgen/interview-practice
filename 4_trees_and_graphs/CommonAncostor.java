public class CommonAncostor {
    TreeNode<Integer> findCommonANcestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (!covers(root, p) || !covers(root, q)) return null;
        else if (covers(p, q)) return p;
        else if (covers(q, p)) return q;

        TreeNode<Integer> sibling = getSibling(p);
        TreeNode<Integer> parent = p.parent;
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    public boolean covers(TreeNode<Integer> root, TreeNode<Integer> p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }

    public TreeNode<Integer> getSibling(TreeNode<Integer> node) {
        if (node == null || node.parent == null) return null;
        TreeNode<Integer> parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }
}