package adityajoshee.Y2K18.apr.D12;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;

/**
 * Created by aditya.joshee on 4/12/18.
 */
public class DistanceBetweenNodesBinaryTree {
    public static void main(String args[]){
        TreeNode t = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t1 = new TreeNode(1);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t8 = new TreeNode(8);
        t.setLeft(t3);
        t3.setLeft(t1);
        t.setRight(t7);
        t7.setRight(t9);
        t9.setLeft(new TreeNode(10));
        t8.setLeft(new TreeNode(11));
        t7.setLeft(t8);
        System.out.println(findDistance(t,8, 10));
    }

    private static int findDistance(TreeNode root, int x, int y){
        TreeNode treeNode = LCA(root, x, y);
        return depth(treeNode, x, 0 ) + depth(treeNode, y, 0);
    }

    private static int depth(TreeNode root, int node, int dist) {
        if (root==null){
            return Integer.MAX_VALUE;
        }
        if (root.data==node){
            return dist;
        }
        int a = depth(root.left, node, dist+1);
        int b = depth(root.right, node, dist+1);
        if (a==Integer.MAX_VALUE){
            return b;
        }
        return a;
    }

    private static TreeNode LCA(TreeNode root, int x, int y) {
        if(root==null){
            return null;
        }
        if (root.data==x || root.data==y){
            return root;
        }
        TreeNode l = LCA(root.left, x, y);
        TreeNode r = LCA(root.right, x, y);

        if (l!=null && r!=null){
            return root;
        }
        if (l==null){
            return r;
        }
        return l;
    }

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode setLeft(TreeNode left) {
            this.left = left;
            return this;
        }

        public TreeNode getRight() {
            return right;
        }

        public TreeNode setRight(TreeNode right) {
            this.right = right;
            return this;
        }
    }
}
