public class LongestPath {

	//Clarified the tree is a binary tree
	public static class Node {
		private int value;
		private Node left = null;
		private Node right = null;

		public Node(int value) {
			this.value = value;
		}
	}

	public static class Tree {
		private Node root;

		public Tree() {
			this.root = null;
		}
	}

	//global variable to store the length of longest path
	static int max = 1;

	public static int longestPathInTree(Node root) {
		helper(root, 1);
		return max;
	}

	//recursive function to traverse the tree
	public static void helper(Node node, int length) {
		//check if node has left
		if(node.left != null) {
			//check if values are consecutive
			if(node.left.value == node.value + 1) {
				helper(node.left, length + 1);
				max = Math.max(length + 1, max);
			} else {
				//if not consecutive, set the current length to 1
				helper(node.left, 1);
			}
		}

		//check if node has right
		if(node.right != null) {
			if(node.right.value == node.value + 1) {
			length++;
				max = Math.max(length, max);
			} else {
				length = 1;
			}
			//recurse into right
			helper(node.right, length);
		}
	}

	public static void main(String args[]) {
		Tree t2 = new Tree();
		t2.root = new Node(1);
		t2.root.left = new Node(2);
		t2.root.right = new Node(3);
		t2.root.left.left = new Node(4);

		System.out.println("1st case: " + longestPathInTree(t2.root));

		Tree tree = new Tree();
		tree.root = new Node(6);
		tree.root.left = new Node(5);
		tree.root.right = new Node(7);
		tree.root.right.left = new Node(8);
		tree.root.right.right = new Node(12);
		tree.root.right.left.left = new Node(9);
		tree.root.right.left.left.left = new Node(15);
		tree.root.right.left.left.right = new Node(10);


		System.out.println("2ns case: " + longestPathInTree(tree.root));
	}
}
