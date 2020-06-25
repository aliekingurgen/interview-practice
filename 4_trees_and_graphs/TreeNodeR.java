import java.util.Random;

/* One node of a binary tree. The data element stored is a single 
 * character.
 */
public class TreeNodeR {
	public int data;      
	public TreeNodeR left;    
	public TreeNodeR right; 
	private int size = 0;

	public TreeNodeR(int d) {
		data = d;
		size = 1;
	}
	
	public void insertInOrder(int d) {
		if (d <= data) {
			if (left == null) {
				left = new TreeNodeR(d);
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				right = new TreeNodeR(d);
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public TreeNodeR find(int d) {
		if (d == data) {
			return this;
		} else if (d <= data) {
			return left != null ? left.find(d) : null;
		} else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}
	
	public TreeNodeR getRandomNode() {
		int leftSize = left == null ? 0 : left.size();
		Random random = new Random();
		int index = random.nextInt(size);
		if (index < leftSize) {
			return left.getRandomNode();
		} else if (index == leftSize) {
			return this;
		} else {
			return right.getRandomNode();
		}
	}
	
	public TreeNodeR getIthNode(int i) {
		int leftSize = left == null ? 0 : left.size();
		if (i < leftSize) {
			return left.getIthNode(i);
		} else if (i == leftSize) {
			return this;
		} else {
			return right.getIthNode(i - (leftSize + 1));
		}
	}
} 