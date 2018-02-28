package adityajoshee.Y2K18.jan.D25;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya.joshee on 1/25/18.
 */
public class MirrorBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(20);
        BinaryNode root = binaryTree.getRoot();
        root.setLeft(10).setRight(15);
        BinaryNode node = root.setRight(30);
        node.setRight(35);
        node.setLeft(29);
        inorder(root);
        System.out.println();
        inorder(mirror(root));
    }

    private static BinaryNode mirror(BinaryNode root) {
        if (root==null){
            return null;
        }
        BinaryNode right = root.getRight();
        BinaryNode left = root.getLeft();

        root.setRight(left);
        root.setLeft(right);
        mirror(left);
        mirror(right);
        return root;
    }
    private static void inorder(BinaryNode node){
        if (node==null){
            return;
        }
        inorder(node.getLeft());
        System.out.print(node+"-");

        inorder(node.getRight());
    }
}
