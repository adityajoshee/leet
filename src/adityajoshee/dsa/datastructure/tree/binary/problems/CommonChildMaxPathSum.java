package adityajoshee.dsa.datastructure.tree.binary.problems;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;


// with a common child b/w parents
/**
 * Created by aditya on 10/14/16.
 */
public class CommonChildMaxPathSum {
    /*
               0a
        6b(25)       14c(125)
    2e(17)    4d(19)      100f(111)

 10        15g      11h          3

     */
    public static void main(String args[]){
        BinaryTree binaryTree = new BinaryTree(0);
        BinaryNode A = binaryTree.getRoot();
        BinaryNode B = A.setLeft(6);
        BinaryNode E = B.setLeft(2);
        E.setLeft(10);
        BinaryNode G = E.setRight(15);
        BinaryNode D = B.setRight(4);
        BinaryNode H = D.setRight(11);
        D.setLeft(G);
        BinaryNode C = A.setRight(14);
        C.setLeft(D);
        BinaryNode F = C.setRight(100);
        F.setLeft(H);
        F.setRight(3);
        System.out.println(maxPathSum(binaryTree));
    }

    private static int maxPathSum(BinaryTree tree){
        return getMaxFV(tree.getRoot(), 0);
    }

    private static int getMaxFV(BinaryNode node, int csum){
        if(node==null){
            return 0;
        }
        if(node.getLeft()==null && node.getRight()==null){
            node.setMaxFamilyValue(node.getData()); // leaf node
            return node.getMaxFamilyValue();
        }
        if (node.getMaxFamilyValue()!=null){
            return node.getMaxFamilyValue();
        }
        int lfv = getMaxFV(node.getLeft(), csum+node.getData());
        int rfv = getMaxFV(node.getRight(), csum+node.getData());
        node.setMaxFamilyValue((lfv>rfv?lfv:rfv) + node.getData());
        return node.getMaxFamilyValue();
    }
}
