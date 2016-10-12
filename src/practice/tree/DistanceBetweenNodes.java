package practice.tree;


/**
 * Created by aditya on 9/18/16.
 */
public class DistanceBetweenNodes {
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
        t9.setLeft(t8);

        findDistance(3,7);
    }

    private static int findDistance(int x, int y){
        return -1; //TODO
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
