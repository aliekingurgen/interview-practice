import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {
    
    public ArrayList<LinkedList<TreeNode<Integer>>> createListOfDepths(TreeNode<Integer> root) {
        ArrayList<LinkedList<TreeNode<Integer>>> lists = new ArrayList<LinkedList<TreeNode<Integer>>>();
        LinkedList<TreeNode<Integer>> curLevel = new LinkedList<TreeNode<Integer>>();
        if (root != null) curLevel.add(root);

        while(curLevel.size() != 0) {
            lists.add(curLevel); // add the previous level
            LinkedList<TreeNode<Integer>> prevLevel = curLevel;
            curLevel = new LinkedList<TreeNode<Integer>>();
            for (TreeNode<Integer> parent : prevLevel) {
                if (parent.left != null) curLevel.add(parent.left);
                if (parent.right != null) curLevel.add(parent.right);
            }
        }
        return lists;
    }
}