package adityajoshee.dsa.datastructure.tree.binary.problems.ancestors;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya on 11/28/16.
 */
public class PrintAncestors {
    public static void main(String args[]){
        BinaryTree tree = new BinaryTree(20);
        BinaryNode A = tree.getRoot();
        BinaryNode B = A.setLeft(6);
        B.setLeft(2);
        B.setRight(4);
        BinaryNode C = A.setRight(14);
        BinaryNode D = C.setLeft(3);
        C.setRight(8);
        D.setLeft(9);
        D.setRight(1);
        isAnc(tree.getRoot(), D);
    }
    private static boolean isAnc(BinaryNode root, BinaryNode node){
        if (root==null){
            return false;
        }
        if (root.getData()==node.getData()) {
            return true; // don't print but return true;
        }
        boolean ld = isAnc(root.getLeft(),node);
        boolean rd = isAnc(root.getRight(),node);
        if (ld || rd){
            System.out.println(root.getData());
        }
        return ld||rd;
    }
}
