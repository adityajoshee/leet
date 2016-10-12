package datastructure.tree.bst;

import datastructure.tree.BinaryNode;
import datastructure.tree.BinaryTree;

/**
 * Created by aditya on 8/13/16.
 */
public class ConstructBSTFromPostorder {

    public static void main(String args[]){
        int[] postorder = new int[] {2,3,6,8,5};//{1,2,4,5,7,6,3};
        BinaryNode bstRoot = construct(postorder,new Index(postorder.length-1),Integer.MIN_VALUE,Integer.MAX_VALUE);
        BinaryTree bst = new BinaryTree(bstRoot);
        bst.postorder();
        bst.preorder();
        bst.inorder();
    }
    private static BinaryNode construct(int[] postorder, Index i, int min, int max){
        BinaryNode node=null;
        if(i.index>=0 && postorder[i.index]>min && postorder[i.index]<max){
            node = new BinaryNode(postorder[i.index]);
            i.index = i.index-1;
            node.setRight(construct(postorder, i, postorder[i.index+1], max));
            node.setLeft(construct(postorder, i, min, postorder[i.index+1]));
        }
        return node;
    }
    public static class Index{
        int index;
        public Index(int i){
            index = i;
        }
    }

}
