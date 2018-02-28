package adityajoshee.dsa.datastructure.tree.binary.bst;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya.j on 4/30/17.
 */
// for bst we can optimise finding lca by not searching if a>root in the root's left sub
public class LCA {
    public static void main(String gargs[]){
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
        //bst.inorder();
        System.out.println(findLca(bst.getRoot(),15,12));
    }
    private static BinaryNode findLca(BinaryNode node, int a, int b){
        if (node==null){
            return null;
        }
        if (node.getData()==a || node.getData()==b){
            return node;
        }
        //TODO optimise since its a bst and not normal binary tree
        BinaryNode leftLca = findLca(node.getLeft(), a, b);
        BinaryNode rightLca = findLca(node.getRight(), a, b);

        if (leftLca!=null && rightLca!=null){
            return node;
        }
        if (leftLca!=null){
            return leftLca;
        }
        return rightLca;
    }


    //optimal
    private  static BinaryNode lca(BinaryNode node, int n1, int n2)
    {
        if (node == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.getData() > n1 && node.getData() > n2)
            return lca(node.getLeft(), n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.getData() < n1 && node.getData() < n2)
            return lca(node.getRight(), n1, n2);

        return node;
    }
}
