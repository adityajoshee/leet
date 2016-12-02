package adityajoshee.dsa.datastructure.tree.binary;

import java.util.ArrayList;

/**
 * Created by aditya on 7/25/16.
 */
public class BinaryTreeDemo {

    /*
               20
         6         14
     2      4    6      8

     */

    public static void main(String args[]){
        BinaryTree binaryTree = new BinaryTree(20);
        BinaryNode A = binaryTree.getRoot();

        BinaryNode B = A.setLeft(6);
        B.setLeft(2);
        B.setRight(4);
        BinaryNode C = A.setRight(14);
        C.setLeft(6);
        C.setRight(8);

        binaryTree.size();
        binaryTree.inorder();
        binaryTree.levelOrderTraversal();
        binaryTree.printLevel(2);
        binaryTree.spiralOrder();
        System.out.println("\nHEIGHT:"+ binaryTree.height());
        System.out.println("\n"+binaryTree.hasRootToLeafSum(10));
        System.out.print("\nDIAMETER: "+binaryTree.diameter());
        System.out.println("\nSize of largest BST :"+null);

        System.out.println("\nLCA:"+binaryTree.lca(4,2).getData()); // assumes atleast 1 node is present

        System.out.println("Child Sum Property : "+binaryTree.childSumProperty());
        binaryTree.printAncestors(2);
        binaryTree.vertical();
        binaryTree.printNodesAtDistanceFromRoot(0);

        BinaryTree bt1 = new BinaryTree(2);
        BinaryNode a1 = bt1.getRoot();
        a1.setRight(1);
        a1.setLeft(4);
        bt1.preorder();
        bt1.inorder();
        ArrayList<Integer> serializedbt1 = bt1.serialize();
        System.out.println(serializedbt1);

        BinaryTree bt2 = new BinaryTree(2);
        BinaryNode a2 = bt2.getRoot();
        a2.setRight(4).setRight(1);
        bt2.preorder();
        bt2.inorder();
        ArrayList<Integer> serializedbt2 = bt2.serialize();
        System.out.println(serializedbt2);

        // deserialize both bt1 and bt2
        bt1 = new BinaryTree(bt1.deserialize(serializedbt1));
        bt2 = new BinaryTree(bt2.deserialize(serializedbt2));
        bt1.preorder();
        bt1.inorder();
        bt2.preorder();
        bt2.inorder();
        bt2.printNodesAtDistanceFromRoot(2);

    }
}
