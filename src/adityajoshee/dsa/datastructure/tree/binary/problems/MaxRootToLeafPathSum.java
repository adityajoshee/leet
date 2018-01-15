package adityajoshee.dsa.datastructure.tree.binary.problems;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;

/**
 * Created by aditya.j on 5/6/17.
 */
public class MaxRootToLeafPathSum {
    public static void main(String args[]){
        BinaryNode root = new BinaryNode(5);
        root.setLeft(3000).setLeft(1);
        BinaryNode r = root.setRight(8);
        r.setLeft(6).setLeft(7).setRight(10);
        r.setRight(-9).setRight(1000);
        Sum maxSum = new Sum();
        find(root,0, maxSum);
        System.out.println(maxSum.val);
    }
    private static void find(BinaryNode node, int sum, Sum finalSum){
        if (node==null){
            return;
        }
        int newsum = sum+node.getData();
        if (node.getLeft()==null && node.getRight()==null && newsum> finalSum.val){
            // only when we reach a leaf node, we have to update the global max sum value.
            finalSum.val = newsum;
        }
        find(node.getLeft(), newsum, finalSum);
        find(node.getRight(), newsum, finalSum );

    }

    static class Sum{
        int val = 0;
    }
}
