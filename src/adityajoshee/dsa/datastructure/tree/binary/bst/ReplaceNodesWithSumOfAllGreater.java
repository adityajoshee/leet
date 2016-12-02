package adityajoshee.dsa.datastructure.tree.binary.bst;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya on 8/17/16.
 */


// for a bst replace all nodes with sum of nodes greater that node and the node itself
public class ReplaceNodesWithSumOfAllGreater {
    public static void main(String args[]){
        BinaryNode root = new BinaryNode(5);
        BinaryTree bst = new BinaryTree(root);
        root.setLeft(3).setLeft(1);
        BinaryNode r = root.setRight(8);
        r.setLeft(6);
        r.setRight(9);
        bst.inorder();
        update(root, new TempSum());
        bst.inorder();
    }
    private static class TempSum{
        int val =0;
    }
    private static void update(BinaryNode n, TempSum sum){
        if(n==null)
            return;

        update(n.getRight(),sum);
        sum.val = sum.val + n.getData();
        n.setData(sum.val);
        update(n.getLeft(),sum);
    }
}
