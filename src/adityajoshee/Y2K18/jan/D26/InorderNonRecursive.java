package adityajoshee.Y2K18.jan.D26;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

import java.util.Stack;

/**
 * Created by aditya.joshee on 1/26/18.
 */
public class InorderNonRecursive {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(20);
        BinaryNode root = binaryTree.getRoot();
        root.setLeft(10).setRight(15);
        BinaryNode node = root.setRight(30);
        node.setRight(35);
        node.setLeft(29);
        inorder(root);
    }

    private static void inorder(BinaryNode root) {
        if (root==null){
            return;
        }
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(root);
        while (root.getLeft()!=null){
            stack.push(root.getLeft());
            root = root.getLeft();
        }
        while (!stack.isEmpty()){
            BinaryNode node = stack.pop();
            System.out.print(node+"-");
            BinaryNode right = node.getRight();
            if (right!=null){
                stack.push(right);
                while (right.getLeft()!=null){
                    stack.push(right.getLeft());
                    right = right.getLeft();
                }
            }
        }
    }
}
