package utilities;

public class Main {
	public static void main(String[] args) {
	
		MyTree tree = new MyTree();
		tree.insert(7);
		tree.insert(4);
		tree.insert(9);
		tree.insert(1);
		tree.insert(6);
		tree.insert(8);
		tree.insert(10);


		System.out.println(tree.find(99));
		// Tree (root)
		// Node (value, leftChild, rightChild)
		// insert(value)
		// find(value):boolean

		
	}
}
