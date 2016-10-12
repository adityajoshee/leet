package datastructure.tree.bst;

import datastructure.tree.BinaryNode;
import datastructure.tree.BinaryTree;

/**
 * Created by aditya on 8/23/16.
 */
public class DeleteKeyFromBST {
    public static void main(String args[]){
        BinaryNode root = new BinaryNode(5);
        BinaryTree bst = new BinaryTree(root);
        root.setLeft(3).setLeft(0);
        BinaryNode r = root.setRight(8);
        r.setLeft(6);
        r.setRight(9);
        bst.inorder();

        root = execute(root, 5);
        bst = new BinaryTree(root);
        bst.inorder();
    }

    private static BinaryNode execute(BinaryNode node, int key){
        if(node==null){
            return node;
        }
        if(node.getData()==key){
            if(isLeaf(node)){
                node = null;
            }
            else if(hasOnlyLeftChild(node)){
                node = node.getLeft();
            }
            else if(hasOnlyRightChild(node)){
                node = node.getRight();
            }
            else{
                node.setData(findMin(node.getRight()));
                execute(node.getRight(),node.getData());
            }
        }
        else{
            // find the key
            node.setLeft(execute(node.getLeft(),key));
            node.setRight(execute(node.getRight(),key));
        }
        return node;
    }

    private static boolean isLeaf(BinaryNode node){
        return node!=null && node.getLeft()==null && node.getRight()==null;
    }

    private static boolean hasOnlyLeftChild(BinaryNode node){
        return node!=null && node.getLeft()!=null && node.getRight()==null;
    }

    private static boolean hasOnlyRightChild(BinaryNode node){
        return node!=null && node.getLeft()==null && node.getRight()!=null;
    }

    private static int findMin(BinaryNode node){
        if(node.getLeft()==null){
            return node.getData();
        }
        return findMin(node.getLeft());
    }
}
