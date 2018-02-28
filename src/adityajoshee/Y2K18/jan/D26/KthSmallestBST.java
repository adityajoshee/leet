package adityajoshee.Y2K18.jan.D26;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya.joshee on 1/26/18.
 */
public class KthSmallestBST {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(20);
        BinaryNode root = binaryTree.getRoot();
        root.setLeft(10).setRight(15);
        BinaryNode node = root.setRight(30);
        node.setRight(35);
        node.setLeft(29);
        System.out.println(kthSmallest(root, new Counter(), 4));
    }

    //inorder traversal, maintain count
    private static int kthSmallest(BinaryNode root, Counter counter, int k) {
        if (root == null){
            return -1;
        }
        int res = kthSmallest(root.getLeft(),counter, k);
        counter.val++;
        if (k==counter.val){
            System.out.println(root.getData());
            return root.getData();
        }
        if (res>-1){
            return res;
        }
        return kthSmallest(root.getRight(), counter, k);
    }

    private static class Counter{
        int val = 0;

        public Counter() {
            this.val = 0;
        }
    }
}
