package adityajoshee.Y2K19.oct;

import java.util.TreeMap;

/**
 * Created by aditya.joshee on 2019-10-06.
 */
public class VerticalViewBinaryTree {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        vv(0, treeMap, new TreeNode(1, new TreeNode(2, null, new TreeNode(4, new TreeNode(5, new TreeNode(6, null, null), null), null)), new TreeNode(3)));
        for(Integer i: treeMap.keySet()){
            System.out.print(treeMap.get(i)+"  ");
        }
    }

    private static void vv(int d, TreeMap<Integer, Integer> treeMap, TreeNode node){
        if(node==null){
            return;
        }
        if (treeMap.get(d)==null){
            treeMap.put(d, node.val);
        }
        vv(d-1, treeMap, node.left);
        vv(d+1, treeMap, node.right);
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
