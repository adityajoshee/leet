package adityajoshee.dsa.datastructure.tree.binary.bst.construct;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya on 8/14/16.
 */

public class ConstructBSTFromPreorder {
    public static void main(String args[]){
        int[] pre = {6,3,1,5,4,9,7,8,10};
        BinaryTree tree = new BinaryTree(construct(pre));
        tree.inorder();
        tree.preorder();
    }
    private static BinaryNode construct(int[] pre){
        return constructHelper(pre, new Index(), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static BinaryNode constructHelper(int[] pre, Index i, int min, int max){
        if (i.val>=pre.length){
            return null;
        }
        if (pre[i.val]<=min || pre[i.val]>=max){
            return null;
        }

        BinaryNode node = new BinaryNode(pre[i.val]);
        i.val += 1;
        node.setLeft(constructHelper(pre, i, min, node.getData()));
        node.setRight(constructHelper(pre, i, node.getData(), max));

        return node;
    }

    private static class Index{
        int val = 0;
    }
}
