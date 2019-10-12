package adityajoshee.Y2K19.oct;

/**
 * Created by aditya.joshee on 2019-10-03.
 */

public class SerializeBinaryTree {
    private static String delimiter = ",";
    private static String nullNode = "x";

    public static void main(String[] args) {
        String x = serialize(new TreeNode(1, new TreeNode(2),
                new TreeNode(3, new TreeNode(4), new TreeNode(5))));
        System.out.println(x);
        System.out.println(deserialize(x));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root==null){
            return "x";
        }
        String ls = serialize(root.left);
        String rs = serialize(root.right);
        return root.val+delimiter+ls+delimiter+rs;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return deserialize(new int[]{0}, nodes);
    }

    // sample input 1,2,x,x,3,4,x,x,5,x,x
    private static TreeNode deserialize(int[] idx, String[] nodes) {
        if (nodes[idx[0]].equals(nullNode)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodes[idx[0]++]));
        root.left = deserialize(idx, nodes);
        root.right = deserialize(idx, nodes);
        return root;
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

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));