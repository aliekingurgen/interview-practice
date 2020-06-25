import java.util.Random;

public class TreeRandom {
	TreeNodeR root = null;
	
	public void insertInOrder(int value) {
		if (root == null) {
			root = new TreeNodeR(value);
		} else {
			root.insertInOrder(value);
		}
	}
	
	public int size() {
		return root == null ? 0 : root.size();
	}
	
	public TreeNodeR getRandomNode() {
		if (root == null) return null;
		
		Random random = new Random();
		int i = random.nextInt(size());
		return root.getIthNode(i);
	}
}