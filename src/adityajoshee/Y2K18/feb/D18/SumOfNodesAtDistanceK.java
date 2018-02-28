package adityajoshee.Y2K18.feb.D18;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya.joshee on 2/18/18.
 */
public class SumOfNodesAtDistanceK {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(4);
        BinaryNode root = binaryTree.getRoot();
        BinaryNode lnode = root.setLeft(8);
        lnode.setLeft(1);
        BinaryNode lrnode = lnode.setRight(3);
        lrnode.setLeft(7).setRight(9);
        lrnode.setRight(2);

        BinaryNode rnode =root.setRight(-1);
        rnode.setLeft(-2);
        rnode.setRight(5).setRight(6);
        Sum sum = new Sum();
        find(9, root, 7, sum);
        System.out.println(sum.val);
    }

    private static int find(int nodeValue, BinaryNode root, int k, Sum sum) {
        if (root==null){
            return -1;
        }
        if (root.getData()==nodeValue){
            addSumOfDescendantsAtDistance(root, k, sum);
            return 1;
        }
        int l = find(nodeValue, root.getLeft(), k, sum);
        int r = find(nodeValue, root.getRight(), k, sum);

        int distanceFromTarget = l>0? k-l : k-r;
        if (distanceFromTarget==0){
            sum.val = sum.val + root.getData();
        }
        else{
            if (l>0){
                addSumOfDescendantsAtDistance(root.getRight(), distanceFromTarget-1, sum);
            }
            if (r>0){
                addSumOfDescendantsAtDistance(root.getLeft(), distanceFromTarget-1, sum);
            }
        }

        return l>0? l+1 : r>0? r+1 : -1;
    }

    private static void addSumOfDescendantsAtDistance(BinaryNode root, int k, Sum sum) {
        if (root==null){
            return;
        }
        if (k==0){
            sum.val = sum.val + root.getData();
        }
        addSumOfDescendantsAtDistance(root.getLeft(), k-1, sum);
        addSumOfDescendantsAtDistance(root.getRight(), k-1, sum);
    }


    private static class Sum {
        int val = 0;
    }
}
