package adityajoshee.Y2K19.sep;

/**
 * Created by aditya.joshee on 2019-09-28.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PathSum2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(0, null, null), null), new TreeNode(3, null, null));
        for(List<Integer> path: pathSum(root, 4)){
            System.out.println(path.toString());
        }
    }
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList();
        find(root, sum, cur, res);
        return res;
    }

    static void find(TreeNode node, int sum, List<Integer> cur, List<List<Integer>> res){
        if (isLeaf(node) && sum-node.val==0){
            cur.add(node.val);
            res.add(new LinkedList<>(cur));
            cur.remove(cur.size()-1);
            return;
        }
        if (node==null || sum-node.val<0){
            return;
        }
        sum = sum - node.val;
        cur.add(node.val);
        find(node.left, sum, cur, res);
        find(node.right, sum, cur, res);
        cur.remove(cur.size()-1);
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static boolean isLeaf(TreeNode node){
        return node!=null && node.left==null && node.right==null;
    }
}