public class MinimalTree {
    public TreeNode<Integer> createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    TreeNode<Integer> createMinimalBST(int[] arr, int start, int end) {
        if (end == start) return null;

        int mid = (start + end) / 2;
        TreeNode<Integer> n = new TreeNode<Integer>(arr[mid]);
        n.left = createMinimalBST(arr, start, mid -1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }
}