package adityajoshee.dsa.datastructure.tree.binary.problems;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;

import java.util.HashMap;

/**
 * Created by aditya on 12/1/16.
 */
public class TopView {
    public static void main(String args[]){
        BinaryNode root = new BinaryNode(5);
        root.setLeft(3).setLeft(1);
        BinaryNode r = root.setRight(8);
        r.setLeft(6).setLeft(7).setRight(10);
        r.setRight(9).setRight(0);
        HashMap<Integer,Integer> disVsNodePresent = new HashMap<>();
        printTopView(root, 0, disVsNodePresent);
        System.out.println();
        printTopViewWithoutMap(root, 0, new AxialDistance());
    }
    private static void printTopView(BinaryNode node, int axialDis, HashMap<Integer,Integer> disVsNodePresent){
        if (node==null){
            return;
        }

        printTopView(node.getLeft(),axialDis-1,disVsNodePresent);
        if (disVsNodePresent.get(axialDis)==null){
            System.out.print(" "+node.getData()+" ");
            disVsNodePresent.put(axialDis,node.getData());
        }
        printTopView(node.getRight(),axialDis+1,disVsNodePresent);
    }

    /*
    traverse in inorder, keep track of max axial distance for which a node has been printed.
     */
    private static void printTopViewWithoutMap(BinaryNode node, int axialDis, AxialDistance axisCompletedTill) {
        if (node == null) {
            return;
        }

        printTopViewWithoutMap(node.getLeft(), axialDis - 1, axisCompletedTill);

        if (axisCompletedTill.val==null || axialDis > axisCompletedTill.val) {
            System.out.print(" " + node.getData() + " ");
            if (axisCompletedTill.val==null){
                axisCompletedTill.val = axialDis;
            }
            else{
                axisCompletedTill.val++;
            }
        }

        printTopViewWithoutMap(node.getRight(), axialDis + 1, axisCompletedTill);
    }

    static class AxialDistance{
        Integer val;
    }
}
