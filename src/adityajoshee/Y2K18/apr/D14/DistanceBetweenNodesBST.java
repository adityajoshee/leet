package adityajoshee.Y2K18.apr.D14;

/**
 * Created by aditya.joshee on 4/13/18.
 */
public class DistanceBetweenNodesBST {
    public static void main(String args[]){
        TreeNode t = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t1 = new TreeNode(1);
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t9 = new TreeNode(9);
        TreeNode t8 = new TreeNode(8);

        t.setLeft(t1);
        t.setRight(t7);
        t1.setRight(t3);
        t7.setLeft(t6);
        t7.setRight(t9);
        t9.setLeft(t8);
        System.out.println(findDistance(t,8, 6));
    }

    private static int findDistance(TreeNode root, int x, int y){
        TreeNode treeNode = LCAForBST(root, x, y);
        return depth(treeNode, x, 0 ) + depth(treeNode, y, 0);
    }

    private static int depth(TreeNode root, int node, int dist) {
        if (root==null){
            return Integer.MAX_VALUE;
        }
        if (root.data==node){
            return dist;
        }
        int l = depth(root.left, node, dist+1);
        return l==Integer.MAX_VALUE ? depth(root.right, node, dist+1) : l;
    }

    private static TreeNode LCAForBST(TreeNode root, int x, int y) {
        if (root==null){
            return null;
        }
//        if (root.data==x || root.data==y){
//            return root;
//        }
//        if ((root.data<x && root.data>y) || (root.data>x && root.data<y)){
//            return root;
//        }
//        TreeNode l = null,r = null;
        if (root.data<x && root.data<y){
            return LCAForBST(root.right, x, y);
        }
        if (root.data>x && root.data>y) {
            return LCAForBST(root.left, x, y);
        }
        return root;
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
