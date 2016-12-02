package adityajoshee.dsa.datastructure.tree.binary.problems;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;

/**
 * Created by aditya on 12/1/16.
 */
//http://www.geeksforgeeks.org/maximum-consecutive-increasing-path-length-in-binary-tree/

public class LongestIncreasingPathBinaryTree {
    public static void main(String args[]){
        BinaryNode root = new BinaryNode(1);
        root.setRight(2).setRight(3).setRight(4).setLeft(5);
        System.out.println(find(root,new MaxTillNow(),0));
    }
    private static int find(BinaryNode node, MaxTillNow max, int currSeqLen){
        if (node==null){
            return 0;
        }
        if (currSeqLen==0){
            currSeqLen++;
        }

        int l=0;
        int r=0;
        if (node.getLeft()!=null){
            if (node.getData()+1==node.getLeft().getData()){
                l = find(node.getLeft(), max, currSeqLen+1);
            }
            else{
                l = find(node.getLeft(), max, 0);
            }
        }
        if (node.getRight()!=null){
            if (node.getData()+1==node.getRight().getData()){
                r = find(node.getRight(), max, currSeqLen+1);
            }
            else{
                r = find(node.getRight(), max, 0);
            }
        }
        return (l>r?l>currSeqLen?l:currSeqLen:r>currSeqLen?r:currSeqLen);
    }

    // not req. to maintain varaible across recursive calls
    static class MaxTillNow{
        int val;
    }
}
