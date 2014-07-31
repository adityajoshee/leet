package datastructure.binarytree;

import datastructure.linkedlist.ListNode;

import java.util.List;

public class BinaryTreeOps {
	public static BinaryNode create(int x){
		BinaryNode n = new BinaryNode();
        n.setData(5);
		return n;
	}

    public static boolean addLeft(BinaryNode n,int x){
        if(n!=null){
            BinaryNode k = new BinaryNode(x);
            n.setLeft(k);
            return true;
        }
        return false;
    }
    public static boolean addRight(BinaryNode n,int x){
        if(n!=null){
            BinaryNode k = new BinaryNode(x);
            n.setRight(k);
            return true;
        }
        return false;
    }


    public static boolean printAncestors(BinaryNode n,int x){
        if(n==null){
            return false;
        }
        if(n.getData()==x){
            return true;
        }
        boolean l = printAncestors(n.getLeft(),x);
        boolean r = printAncestors(n.getRight(),x);

        if(l||r) {
            System.out.print(n.getData() + " ");
            return true;
        }
        return false;
    }

    /*
    public static BinaryNode leftAlignedTree(BinaryNode n){
        BinaryNode[] helper;

    }
    */
	

}
