package adityajoshee.Y2K19.oct;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by aditya.joshee on 2019-10-06.
 */
class VerticalOrderTraversalBinaryTree {
    public static void main(String[] args) {
        List<List<Integer>> res = verticalTraversal( new TreeNode(1, new TreeNode(2, null, new TreeNode(4, new TreeNode(5, new TreeNode(6, null, null), null), null)), new TreeNode(3)));
        System.out.println(res);
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> ys : map.values()) {
            List<Integer> ll = new ArrayList<>();
            list.add(ll);
            for (List<Integer> nodes : ys.values()) {
                ll.addAll(nodes);
            }
        }
        return list;
    }
    private static void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new ArrayList<>());
        }
        map.get(x).get(y).add(root.val);
        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


// class Solution {
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         Map<Integer, List<Integer>> map = new TreeMap();
//         vt(0, map, root);
//         List<List<Integer>> res = new ArrayList();
//         for(int d: map.keySet()){
//             res.add(map.get(d));
//         }
//         return res;
//     }
//     private void vt(int d, Map<Integer, List<Integer>> map, TreeNode node){
//         if(node==null){
//             return;
//         }
//         List<Integer> list = map.get(d);
//         if(list==null){
//             list = new ArrayList();
//             map.put(d, list);
//         }
//         list.add(node.val);
//         vt(d-1, map, node.left);
//         vt(d+1, map, node.right);
//     }
// }