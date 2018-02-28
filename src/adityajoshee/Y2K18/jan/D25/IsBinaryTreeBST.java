package adityajoshee.Y2K18.jan.D25;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya.joshee on 1/25/18.
 */
public class IsBinaryTreeBST {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(3);
        BinaryNode root = binaryTree.getRoot();
        root.setRight(5);
        BinaryNode node = root.setLeft(2);
//        node.setRight(4);
        node.setLeft(1);
        System.out.println(isBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isBSTByInorder(root,new BinaryNode(-1)));
    }

    //recursive
    private static boolean isBST(BinaryNode root, int min, int max) {
        if (root == null){
            return true;
        }
        if (!(root.getData()<max && root.getData()>min)){
            return false;
        }
        return isBST(root.getLeft(), min, root.getData()) && isBST(root.getRight(), root.getData(), max);
    }

    //nonrecursive
    private static boolean isBSTT(BinaryNode root){
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        boolean isBST = true;
        while(root!=null){
            if (root.getData()>=high || root.getData()<=low ){
                isBST = false;
                break;
            }

        }
        return false;

    }

    private static boolean isBSTByInorder(BinaryNode root, BinaryNode prev){
        if (root==null){
            return true;
        }
        boolean b1 = isBSTByInorder(root.getLeft(), prev);
        if(root.getData()>prev.getData()){
            prev.setData(root.getData());
        }
        else{
            return false;
        }
        boolean b2 = isBSTByInorder(root.getRight(), prev);
        return b1 && b2;
    }
}
