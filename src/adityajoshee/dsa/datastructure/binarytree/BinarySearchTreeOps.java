package adityajoshee.dsa.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeOps {
	public static BinaryNode create(int rootValue){
		BinaryNode n = new BinaryNode(rootValue);
		return n;
	}
	public static Boolean add(BinaryNode root,int data){
		BinaryNode temp=null;
		int willBeLeftChild=-1;
		while(root!=null){
			if(data<=root.getData()){
				temp=root;
				root=root.getLeft();
				willBeLeftChild=1;
			}
			else{
				temp=root;
				root=root.getRight();
				willBeLeftChild=0;
			}
		}
		if(willBeLeftChild==1 && temp!=null){
			BinaryNode n = new BinaryNode(data);
			temp.setLeft(n);
		}
		else if(willBeLeftChild==0 && temp!=null){
			BinaryNode n = new BinaryNode(data);
			temp.setRight(n);
		}
		return true;
	}
	
	public static void inOrder(BinaryNode root){
		if(root!=null){
			inOrder(root.getLeft());
			System.out.print(root.getData()+" ");
			inOrder(root.getRight());
		}
	}
	
	public static void preOrder(BinaryNode root	){
		if(root!=null){
			System.out.print(root.getData()+" ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}
	
	public static void printNodeAtDistance(BinaryNode root, int k){
		if(root!=null){
			if(k==0){
				System.out.print(root.getData()+" ");
				return;
			}
			printNodeAtDistance(root.getLeft(),k-1);
			printNodeAtDistance(root.getRight(),k-1);
		}
	}
	
	public static void bfs(BinaryNode root){
		if(root!=null){
			Queue<BinaryNode> q = new LinkedList<BinaryNode>();
			q.add(root);
			while(!q.isEmpty()){
				BinaryNode t = q.remove();
				System.out.print(t.getData() + " ");
				if(t.getLeft()!=null){
					q.add(t.getLeft());
				}
				if(t.getRight()!=null){
					q.add(t.getRight());
				}
			}
		}
	}
	
	public static void dfs(BinaryNode root){
		if(root!=null){
			Stack<BinaryNode> s  = new Stack<BinaryNode>();
			s.push(root);
			while(!s.isEmpty()){
				BinaryNode t = s.pop();
				System.out.print(t.getData()+" ");
				if(t.getRight()!=null){
					s.push(t.getRight());
				}
				if(t.getLeft()!=null){
					s.push(t.getLeft());
				}
			}
		}
	}


    // Print boundary of a binary tree :

	public static void printBoundary(BinaryNode root){
		System.out.println("\nBinary Tree Boundary :     ");
		printPreorderLeftOnly(root);
		printInorderLeafOnly(root);
		printPostOrderRightOnly(root);
	}
	
	private static void printPreorderLeftOnly(BinaryNode root){
		if(root!=null){
			if(!isLeaf(root))
				System.out.print(root.getData()+" ");
			printPreorderLeftOnly(root.getLeft());
		}
	}
	
	private static void printInorderLeafOnly(BinaryNode root){
		if(root!=null){
			printInorderLeafOnly(root.getLeft());
			if(root.getLeft()==null && root.getRight()==null){
				System.out.print(root.getData() +" ");
			}
			printInorderLeafOnly(root.getRight());
		}
	}
	
	private static void printPostOrderRightOnly(BinaryNode root){
		if(root!=null){
			printPostOrderRightOnly(root.getRight());
			if(!isLeaf(root))
				System.out.print(root.getData()+ " ");
		}
	}
	
	public static boolean isLeaf(BinaryNode node){
		if(node.getLeft()==null && node.getRight()==null){
			return true;
		}
		return false;
	}
}
