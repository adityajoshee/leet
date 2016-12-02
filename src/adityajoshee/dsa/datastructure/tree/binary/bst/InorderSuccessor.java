package adityajoshee.dsa.datastructure.tree.binary.bst;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya on 8/23/16.
 */
public class InorderSuccessor {
    public static void main(String args[]){
        BinaryNode root = new BinaryNode(5);
        BinaryTree bst = new BinaryTree(root);
        root.setLeft(3).setLeft(0);
        BinaryNode r = root.setRight(8);
        r.setLeft(6).setRight(7);
        r.setRight(9);
        bst.inorder();

        root = find(root, 5, new LeastGreaterNode());
        System.out.println("\nINORDER SUCC: "+root);
    }

    // if rightsubtree exists then get min of that else least greater ancestor
    private static BinaryNode find(BinaryNode node, int x, LeastGreaterNode lgn){
        if(node==null){
            return null;
        }
        if((lgn.val==null && node.getData()>x) || (node.getData()>x && node.getData()<lgn.val.getData())){
            lgn.val = node;
        }
        if(node.getData()==x){
            if(node.getRight()!=null){
                return findMin(node.getRight());
            }
            return lgn.val;
        }
        if(x>node.getData()){
            return find(node.getRight(),x,lgn);
        }
        return find(node.getLeft(),x,lgn);

    }

    private static class LeastGreaterNode{
        BinaryNode val;
    }
    private static BinaryNode findMin(BinaryNode node){
        if(node==null){
            return null;
        }
        while(node.getLeft()!=null){
            node = node.getLeft();
        }
        return node;
    }
}
