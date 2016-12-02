package adityajoshee.dsa.datastructure.tree.binary.problems;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya on 12/1/16.
 */
public class LeftView {
    public static void main(String args[]){
        BinaryNode root = new BinaryNode(5);
        root.setLeft(3).setLeft(1);
        BinaryNode r = root.setRight(8);
        r.setLeft(6).setLeft(7).setRight(10);
        r.setRight(9).setRight(0);
        printLeftView(root, 0, new Level(-1));
    }
    /*
    traverse in preorder manner...keep track of current and completed levels. Since we
    are traversing in inorder, left nodes will always come before right ones.
     */
    private static void printLeftView(BinaryNode node, int currLevel, Level completedLevel){
        if (node==null){
            return;
        }
        if (currLevel>completedLevel.val){
            System.out.println(node.getData());
            completedLevel.val++;
        }
        printLeftView(node.getLeft(), currLevel+1, completedLevel);
        printLeftView(node.getRight(), currLevel+1, completedLevel);
    }

    static class Level{
        int val;
        public Level(int v){
            this.val = v;
        }
    }
}
