package adityajoshee.dsa.datastructure.tree.binary.problems.verticalView;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya on 11/28/16.
 */
public class PrintVerticalNoExtraSpace {
    public static void main(String args[]) {
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
        print(tree.getRoot());
    }
    private static void print(BinaryNode node){
        //TODO
    }
}
