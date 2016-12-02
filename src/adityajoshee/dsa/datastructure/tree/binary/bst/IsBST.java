package adityajoshee.dsa.datastructure.tree.binary.bst;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya on 8/23/16.
 */
public class IsBST {
    public static void main(String args[]){
        BinaryNode root = new BinaryNode(5);
        BinaryTree bst = new BinaryTree(root);
        root.setLeft(3).setLeft(2);
        BinaryNode r = root.setRight(7);
        r.setLeft(6);
        r.setRight(8);
        bst.inorder();
        System.out.println("\nIs BST: "+check(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }
    private static boolean check(BinaryNode node, int min, int max){
        if(node==null){
            return true;
        }
        if(node.getData()<=min || node.getData()>=max){
            return false;
        }
        return check(node.getLeft(), min, node.getData()) && check(node.getRight(), node.getData(), max);
    }
}
