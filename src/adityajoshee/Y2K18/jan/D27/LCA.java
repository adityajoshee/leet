package adityajoshee.Y2K18.jan.D27;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya.joshee on 1/27/18.
 */
public class LCA {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(20);
        BinaryNode root = binaryTree.getRoot();
        root.setLeft(10).setRight(15);
        BinaryNode node = root.setRight(30);
        node.setRight(35);
        node.setLeft(29).setRight(100);
        System.out.println(find(root, 100, 29));
    }

    private static BinaryNode find(BinaryNode root, int x, int y) {
        if (root==null){
            return null;
        }
        if (root.getData()==x || root.getData()==y){
            return root;
        }

        BinaryNode left = find(root.getLeft(), x, y);
        BinaryNode right = find(root.getRight(), x, y);

        if (left!=null && right!=null){
            return root;
        }
        if (left!=null){
            return left;
        }
        return right;
    }

}
