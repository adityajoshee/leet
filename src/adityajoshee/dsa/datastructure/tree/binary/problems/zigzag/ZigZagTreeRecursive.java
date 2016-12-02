package adityajoshee.dsa.datastructure.tree.binary.problems.zigzag;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

import java.util.Stack;

/**
 * Created by aditya on 10/22/16.
 */
public class ZigZagTreeRecursive {
    /*
               20
           6    |      14
       2   |   4 3     |      8
           9           1
*/
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree(20);
        BinaryNode A = tree.getRoot();

        BinaryNode B = A.setLeft(6);
        B.setLeft(2);
        B.setRight(4);
        BinaryNode C = A.setRight(14);
        BinaryNode D = C.setLeft(3);
        C.setRight(8);
        D.setLeft(9);
        D.setRight(1);
        zigZag(tree.getRoot());
    }
    private static void zigZag(BinaryNode node){
        Stack<BinaryNode> stack1 = new Stack<>();
        Stack<BinaryNode> stack2 = new Stack<>();
        stack1.push(node);
        helper(stack1, stack2, true);
    }
    private static void helper(Stack<BinaryNode> s1, Stack<BinaryNode> s2, boolean right){
        while(!s1.empty()) {
            BinaryNode n = s1.pop();
            System.out.print(n.getData() + " -> ");
            if (right) {
                if (n.getLeft() != null) {
                    s2.push(n.getLeft());
                }
                if (n.getRight() != null) {
                    s2.push(n.getRight());
                }
            } else {
                if (n.getRight() != null) {
                    s2.push(n.getRight());
                }
                if (n.getLeft() != null) {
                    s2.push(n.getLeft());
                }
            }
        }
        if (!s2.empty())
            helper(s2, s1, !right);
    }
}
