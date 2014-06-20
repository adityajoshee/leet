package datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

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
		
	}
}
