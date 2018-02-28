package adityajoshee.Y2K18.jan.D27;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya.joshee on 1/27/18.
 */
public class MaxSumLeafToLeafBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(8);
        BinaryNode root = binaryTree.getRoot();
        BinaryNode rleft = root.setLeft(3);
            rleft.setLeft(50);
            BinaryNode t = rleft.setRight(6);
                    t.setLeft(40);
                    t.setRight(7);
        BinaryNode node = root.setRight(10);
        node.setRight(14).setLeft(100);
        MaxSum maxSum1 = new MaxSum();

        System.out.println(find(root, maxSum1));

        MaxSum maxSum2 = new MaxSum();
        maxSumL2L(root, maxSum2);
        System.out.println(maxSum2.val);
    }

    // O(n2) solution....can be optimized to n
    private static int find(BinaryNode root, MaxSum maxSum) {
        if (root==null){
            return 0;
        }
        find(root.getLeft(), maxSum);
        int x = findMaxRootToLeafPath(root.getLeft(), new MaxSum(), 0);
        int y = findMaxRootToLeafPath(root.getRight(), new MaxSum(), 0);
        if (maxSum.val < (root.getData() + x + y)){
            maxSum.val = root.getData() + x + y;
        }
        find(root.getRight(), maxSum);
        return maxSum.val;
    }

    private static int findMaxRootToLeafPath(BinaryNode node, MaxSum maxSum, int currSum) {
        if (node==null){
            return 0;
        }
        currSum = currSum + node.getData();
        if (node.getLeft()==null && node.getRight()==null){ // check sum only for leaves
            if (maxSum.val < currSum){
                maxSum.val = currSum;
            }
        }
        findMaxRootToLeafPath(node.getLeft(), maxSum, currSum);
        findMaxRootToLeafPath(node.getRight(), maxSum, currSum);
        return maxSum.val;
    }

    private static class MaxSum{
        int val = 0;
    }

    //optimal solution
    private static int maxSumL2L(BinaryNode node, MaxSum maxSum){
        if (node==null){
            return 0;
        }
        int lsum = maxSumL2L(node.getLeft(), maxSum);
        int rsum = maxSumL2L(node.getRight(), maxSum);
        if (node.hasBothChildren() && lsum+rsum+node.getData()>maxSum.val){
            maxSum.val = lsum + rsum + node.getData();
        }
        return node.getData() + Math.max(lsum, rsum);
    }
}
