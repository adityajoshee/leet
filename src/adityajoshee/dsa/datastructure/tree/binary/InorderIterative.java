package adityajoshee.dsa.datastructure.tree.binary;


import java.util.Stack;

/**
 * Created by aditya.j on 5/1/17.
 */
public class InorderIterative {
    public static void main(String args[]){
        BinaryNode root = BinaryTree.getSampleBST().getRoot();
        inOrderWithoutRecursion(root);
    }
    private static void doInorder(BinaryNode root){
        if (root==null){
            return;
        }

        Stack<BinaryNode> stack = new Stack<>();
        stack.push(root);

        while (stack.peek().getLeft()!=null){
            stack.push(stack.peek().getLeft());
        }

        while (!stack.isEmpty()){
            BinaryNode top = stack.pop();
            System.out.println(top);
            if (top.getRight()!=null){
                stack.push(top.getRight());
                while(stack.peek().getLeft()!=null){
                    stack.push(stack.peek().getLeft());
                }
            }
        }
    }

    public static void inOrderWithoutRecursion(BinaryNode root) {
        Stack<BinaryNode> nodes = new Stack<>();
        BinaryNode current = root;
        while (!nodes.isEmpty() || current != null) {
            if (current != null) {
                nodes.push(current);
                current = current.getLeft();
            }
            else { // if nodes is not empty
                BinaryNode node = nodes.pop();
                System.out.printf("%s , %s", node.getData(), ":");
                current = node.getRight();
            }
        }
    }

}
