package adityajoshee.Y2K18.jan.D27;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya.joshee on 1/27/18.
 */
public class AncestorsBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(20);
        BinaryNode root = binaryTree.getRoot();
        root.setLeft(10).setRight(15);
        BinaryNode node = root.setRight(30);
        node.setRight(35);
        node.setLeft(29).setRight(100);
        printAncestors(root, new BinaryNode(100));
    }

    private static boolean printAncestors(BinaryNode root, BinaryNode target) {
        if (root==null){
            return false;
        }
        if (root.getData()==target.getData()){
            return true;
        }
        boolean bl = printAncestors(root.getLeft(), target);
        boolean br = printAncestors(root.getRight(), target);
        if (bl || br){
            System.out.println(root.getData());
            return true;
        }
        return false;
    }

}
