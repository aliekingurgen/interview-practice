public class CheckSubtree {
    public boolean isSubtree(TreeNode<Integer> t1, TreeNode<Integer> t2) {
        if (t2 == null) return true;
        return subTree(t1, t2);
    }

    private boolean subTree(TreeNode<Integer> r1, TreeNode<Integer> r2) {
        if (r1 == null) return false;
        else if (r1.value == r2.value && matchTree(r1, r2)) return true;
        else return (subTree(r1.left, r2) || subTree(r1.right, r2));
    }

    private boolean matchTree(TreeNode<Integer> r1, TreeNode<Integer> r2) {
        if (r1 == null && r2 == null) return true; // nothing left in the subtree
        else if (r1 == null || r2 == null) return false; // big tree is empty
        else if (r1.value != r2.value) return false; // doesn't match
        else return (matchTree(r1.left, r2.left) || matchTree(r1.right, r2.right));
    }
}