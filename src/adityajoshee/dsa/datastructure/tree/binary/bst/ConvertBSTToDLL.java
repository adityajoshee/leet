package adityajoshee.dsa.datastructure.tree.binary.bst;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya on 8/15/16.
 */
public class ConvertBSTToDLL {
    public static void main(String args[]){
        BinaryNode root = new BinaryNode(5);
        BinaryTree bst = new BinaryTree(root);
        root.setLeft(3).setLeft(0);
        BinaryNode r = root.setRight(8);
        r.setLeft(6);
        r.setRight(9);

        bst.inorder();
        bst.convertToDoublyLinkedList().printSuccessors();
    }
}
