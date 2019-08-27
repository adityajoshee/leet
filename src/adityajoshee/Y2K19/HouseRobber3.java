package adityajoshee.Y2K19;

/**
 * Created by aditya.joshee on 2019-08-25.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class HouseRobber3 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        System.out.println(rob(treeNode));
    }
    public static int rob(TreeNode root) {
        int[] loot = new int[2];
        loot[0]=0;
        loot[1]=root.val; // par is robbed
        rob(root.left, loot);
        rob(root.right, loot);
        return Math.max(loot[0], loot[1]);
    }

    static int[] rob(TreeNode n, int[] loot){
        int t = loot[0];
        loot[0] = Math.max(loot[0], loot[1]); // loot[0] par is not robbed
        if(n!=null)
            loot[1] = n.val+t; // loot[1] par is robbed

        if (n!=null) rob(n.left, loot);
        if(n!=null) rob(n.right, loot);


        return loot;
    }

     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }
}