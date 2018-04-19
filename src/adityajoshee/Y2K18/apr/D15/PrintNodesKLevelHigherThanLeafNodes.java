package adityajoshee.Y2K18.apr.D15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aditya.joshee on 4/15/18.
 */
public class PrintNodesKLevelHigherThanLeafNodes {
    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(2);
        root.left = new BinaryNode(3);
        root.right = new BinaryNode(4);
        root.left.left = new BinaryNode(7);
        root.right.left = new BinaryNode(6);
        root.right.left.right = new BinaryNode(8);
        root.right.right = new BinaryNode(5);

        print(root, 2, new ArrayList<>(), new HashSet<BinaryNode>());
    }

    private static void print(BinaryNode root, int k, List<BinaryNode> currentAncestors, Set<BinaryNode> set) {
        if (root==null){
            return;
        }
        if (root.left==null & root.right==null){
            if (currentAncestors.size()>=k){
                BinaryNode target = currentAncestors.get(currentAncestors.size()-k);
                if(set.add(target)){
                    System.out.println(target.data);
                }
            }
        }
        currentAncestors.add(root);
        print(root.left, k, currentAncestors, set);
        print(root.right, k, currentAncestors, set);
        currentAncestors.remove(currentAncestors.size()-1);
    }

    public static class BinaryNode{
        int data;
        BinaryNode left;
        BinaryNode right;

        public BinaryNode(int data) {
            this.data = data;
        }
    }
}
