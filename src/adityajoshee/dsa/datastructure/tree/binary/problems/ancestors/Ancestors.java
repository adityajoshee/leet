package adityajoshee.dsa.datastructure.tree.binary.problems.ancestors;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya on 10/23/16.
 */
public class Ancestors {
    /*
               20
         6         14
     2      4    6      8

*/
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree(20);
        BinaryNode A = tree.getRoot();

        BinaryNode B = A.setLeft(6);
        B.setLeft(2);
        BinaryNode D = B.setRight(4);
        BinaryNode C = A.setRight(14);
        C.setLeft(6);
        C.setRight(8);
        printAncestors(A,D); //4
    }
    private static void printAncestors(BinaryNode root,BinaryNode node){
        helper(root, node);
    }

    private static boolean helper(BinaryNode root,BinaryNode node){
        if (root==null){
            return false;
        }
        if (root.getData() == node.getData()){
            return true;
        }
        boolean isLeftDescendant = helper(root.getLeft(), node);
        boolean isRightDescendant = helper(root.getRight(), node);
        if (isLeftDescendant || isRightDescendant){
            System.out.print(root.getData()+" ");
        }
        return isLeftDescendant || isRightDescendant;
    }
}
