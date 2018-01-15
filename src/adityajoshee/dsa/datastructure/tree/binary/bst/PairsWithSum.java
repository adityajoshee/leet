package adityajoshee.dsa.datastructure.tree.binary.bst;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

import java.util.Stack;

/**
 * Created by aditya.j on 4/30/17.
 */
public class PairsWithSum {

    public static void main(String args[]){
        BinaryNode root = new BinaryNode(10);
        BinaryTree bst = new BinaryTree(root);
        root.setLeft(5);
        root.setRight(15);
        root.getLeft().setLeft(0);
        root.getLeft().setRight(7);
        root.getLeft().getRight().setLeft(6);
        root.getLeft().getRight().setRight(9);

        root.getRight().setLeft(12);
        root.getRight().setRight(20);
        root.getRight().getLeft().setLeft(11);
        root.getRight().getLeft().setRight(14);
        bst.inorder();
        printAllPairsWithSum(bst.getRoot(), 16);
    }
    private static void printAllPairsWithSum(BinaryNode node, int sum){
        Stack<BinaryNode> stackInc = new Stack<>();
        Stack<BinaryNode> stackDec = new Stack<>();
        stackInc.push(node);
        while(stackInc.peek().getLeft()!=null){
            stackInc.push(stackInc.peek().getLeft());
        }
        stackDec.push(node);
        while (stackDec.peek().getRight()!=null){
            stackDec.push(stackDec.peek().getRight());
        }
        int lowerVal = -1 , higherVal = -1 ;
        boolean getNextHigher = true;
        boolean getNextLower = true;
        while(true){

            if(getNextHigher && !stackInc.empty()){
                BinaryNode top = stackInc.pop();
                lowerVal = top.getData();
                if (top.getRight()!=null){
                    stackInc.push(top.getRight());
                    while(stackInc.peek().getLeft()!=null){
                        stackInc.push(stackInc.peek().getLeft());
                    }
                }
            }

            if(getNextLower && !stackInc.empty()){
                BinaryNode top = stackDec.pop();
                higherVal = top.getData();
                if (top.getLeft()!=null){
                    stackDec.push(top.getLeft());
                    while(stackDec.peek().getRight()!=null){
                        stackDec.push(stackDec.peek().getRight());
                    }
                }
            }

            if (lowerVal>=higherVal || (lowerVal==higherVal && lowerVal!=-1)){
                break;
            }
            if(lowerVal + higherVal == sum){
                System.out.println(lowerVal+","+higherVal);
                getNextHigher = true;
                getNextLower = true;
            }
            else if(lowerVal + higherVal > sum){
                getNextLower = true;
                getNextHigher = false;
            }
            else{
                getNextHigher = true;
                getNextLower = false;
            }

        }
    }
}
