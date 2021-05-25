package utilities;

public class MyTree {

	private class Node{
		private int value;
		private Node leftChild;
		private Node rightChild;
		
		public Node(int value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Node= " + value;
		}
	}
	
	private Node root;
	
	public void insert(int value) {
		Node node = new Node(value);
		
		if (root == null) {
			root = node;
			return;
		}
		
		Node current = root;
		while(true) {
			if(value < current.value) {
				if(current.leftChild == null) {
					current.leftChild = node;
					break;
				}
				current = current.leftChild;
			}
			else {
				if(current.rightChild == null) {
					current.rightChild = node;
					break;
				}
				current = current.rightChild;
			}
		}
	}
	
	public boolean find(int value) {
		Node current = root;
		while(current !=null) {
			if(value < current.value) {
				current = current.leftChild;
			}else if( value > current.value) {
				current = current.rightChild;
			}
			else return true;
		}
		return false;
	}

	public void traversePreOrder() {
		traversePreOrder(root);
	}
	
	private void traversePreOrder(Node root) {
		// base condition
		if (root == null)
			return;
		// root (print)
		System.out.println(root.value);
		// left
		traversePreOrder(root.leftChild);
		// right
		traversePreOrder(root.rightChild);
	}

	public void traverseInOrder() {
		traverseInOrder(root);
	}
	
	private void traverseInOrder(Node root) {
		// base condition
		if (root == null)
			return;
		// left
		traverseInOrder(root.leftChild);
		// root
		System.out.println(root.value);
		// right
		traverseInOrder(root.rightChild);
		
		}
	
	public void traversePostOrder() {
		traversePostOrder(root);
	}
	
	private void traversePostOrder(Node root) {
		// base condition
		if (root == null)
			return;
		// left
		traverseInOrder(root.leftChild);	
		// right
		traverseInOrder(root.rightChild);
		// root
		System.out.println(root.value);
		
		}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node root) {
		
		if (root == null)
			return -1; 
		
		if(isLeaf(root))
			return 0;
		
		return 1 + Math.max(height(root.leftChild), height(root.rightChild));
	}

	private boolean isLeaf(Node node) {
		return node.leftChild == null && node.rightChild == null;
	}
	
	public int leftMostNode() {
		if(root == null)
			throw new IllegalStateException();
		
		Node current = root;
		Node last = current;
		while(current != null) {
			last = current;
			current = current.leftChild;
		}
		return last.value;
	}
	
	public int min() {
		return min(root);
	}
	
	private int min(Node root) {
		
		if(isLeaf(root))
			return root.value;
		
		int left = min(root.leftChild);
		int right = min(root.rightChild);
		
		return Math.min(Math.min(left, right), root.value);
	}

	public boolean equals(MyTree other) {
		if(other == null)
			return false;
		
		return equals(root, other.root);
	}
	
	private boolean equals(Node first, Node second) {
		if (first == null && second == null)
			return true;
		
		if(first != null && second !=null)
			return first.value == second.value
					&& equals(first.leftChild, second.leftChild)
					&& equals(first.rightChild, second.rightChild);
		
		return false;
	}

	public boolean isBinarySearchTree() {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBinarySearchTree(Node root, int min, int max) {
		if(root == null) 
			return true;
		
		if(root.value < min || root.value > max)
			return false;
		
		return
			isBinarySearchTree(root.leftChild, min, root.value -1)
			&& isBinarySearchTree(root.rightChild, root.value +1, max);
	}

	public void printNodesAtDistance(int distance) {
		printNodesAtDistance(root, distance);
	}

	private void printNodesAtDistance(Node root, int distance) {
		if (root == null)
			return;
		
		if (distance == 0) {
			System.out.println(root.value);
			return;
		}
		
		printNodesAtDistance(root.leftChild, distance-1);
		printNodesAtDistance(root.rightChild, distance-1);
	}
}

