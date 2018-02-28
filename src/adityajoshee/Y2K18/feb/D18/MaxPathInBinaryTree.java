package adityajoshee.Y2K18.feb.D18;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya.joshee on 2/18/18.
 */
public class MaxPathInBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(-2);
        BinaryNode root = binaryTree.getRoot();
        BinaryNode lnode = root.setLeft(5);
        lnode.setLeft(-7);
        BinaryNode lrnode = lnode.setRight(-8);
        lrnode.setLeft(5);
        lrnode.setRight(-3);

        BinaryNode rnode =root.setRight(-1);
        rnode.setLeft(-2);
        rnode.setRight(5).setRight(1);

        MaxSum maxSum = new MaxSum();
        find(root, maxSum);
        System.out.println(maxSum.val);
    }

    public static int find(BinaryNode node, MaxSum maxSum){
        if (node==null){
            return 0;
        }
        int l = find(node.getLeft(), maxSum);
        int r = find(node.getRight(), maxSum);
        int max = findMaxCombinationOf(l, node.getData(), r);
        if (maxSum.val<max){
            maxSum.val = max;
        }
        return Math.max(Math.max(node.getData(), node.getData()+l), node.getData()+r);
    }

    private static class MaxSum{
        int val;

        public MaxSum() {
            val = Integer.MIN_VALUE;
        }
    }

    private static int findMaxCombinationOf(int a , int b, int c){
        int max = a;
        if (a+b+c>max){
            max = a+b+c;
        }
        if (a+b>max){
            max = a+b;
        }
        if (c>max){
            max = c;
        }
        if (b>max){
            max = b;
        }
        if (b+c>max){
            max = b+c;
        }
        return max;
    }
}
