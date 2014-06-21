package datastructure.binarytree;

public class BSTDemo {
	public static void main(String[] args){
		BinaryNode root =BinarySearchTreeOps.create(5);
	//	BinarySearchTreeOps.inOrder(root);
		BinarySearchTreeOps.add(root, 4);
		BinarySearchTreeOps.add(root, 7);
		BinarySearchTreeOps.add(root, 6);
		BinarySearchTreeOps.add(root, 2);
		BinarySearchTreeOps.add(root, 1);
		BinarySearchTreeOps.add(root, 3);
		BinarySearchTreeOps.add(root, 9);
		
		System.out.println("In Order: ");BinarySearchTreeOps.inOrder(root);
		
		System.out.println("\nPre Order: ");BinarySearchTreeOps.preOrder(root);
		
		System.out.println("\nBreadth First Traversal: ");
		BinarySearchTreeOps.bfs(root);
		
		System.out.println("\nDepth First Traversal: ");
		BinarySearchTreeOps.dfs(root);
		
		System.out.println("\nNodes at distance 2 from root: ");
		BinarySearchTreeOps.printNodeAtDistance(root, 2);
		
		BinarySearchTreeOps.printBoundary(root);
	}
}
