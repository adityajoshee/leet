package adityajoshee.Y2K18.jan.D27;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya.joshee on 1/27/18.
 */
public class MaxRootToLeafSum {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(0);
        BinaryNode root = binaryTree.getRoot();
        root.setLeft(1).setRight(17);
        BinaryNode node = root.setRight(16);
        node.setRight(50);
        node.setLeft(9).setRight(2);
        MaxSum maxSum = new MaxSum();
        find(root, maxSum, 0);
        System.out.println(maxSum.val);
    }

    private static void find(BinaryNode root, MaxSum maxSum, int currSum) {
        if (root==null){
            return;
        }
        currSum = currSum + root.getData();

        if (root.getLeft()==null && root.getRight()==null){ // if leaf
            if (maxSum.val<currSum){
                maxSum.val = currSum;
            }
        }
        find(root.getLeft(), maxSum, currSum);
        find(root.getRight(), maxSum, currSum);
    }

    private static class MaxSum{
        int val = 0;
    }
}
