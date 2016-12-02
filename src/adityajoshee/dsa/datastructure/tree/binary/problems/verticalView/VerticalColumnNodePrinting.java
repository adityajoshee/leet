package adityajoshee.dsa.datastructure.tree.binary.problems.verticalView;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

import java.util.*;

/**
 * Created by aditya on 11/28/16.
 */
public class VerticalColumnNodePrinting {
    public static void main(String args[]){
        BinaryTree tree = new BinaryTree(20);
        BinaryNode A = tree.getRoot();
        BinaryNode B = A.setLeft(6);
        B.setLeft(2);
        B.setRight(4);
        BinaryNode C = A.setRight(14);
        BinaryNode D = C.setLeft(3);
        C.setRight(8);
        D.setLeft(9);
        D.setRight(1);
        Map<Integer,LinkedList<Integer>> map = new LinkedHashMap<>();
        print(tree.getRoot(),0,map);
        for (Integer i: map.keySet() ) {
            LinkedList<Integer> list = map.get(i);
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
    //inorder traversal with distance from axis
    private static void print(BinaryNode node, int axis, Map<Integer,LinkedList<Integer>> map){
        if (node==null){
            return;
        }
        print(node.getLeft(),axis-1,map);
        LinkedList<Integer> list = map.get(axis);
        if (list==null){
            list = new LinkedList<>();
            map.put(axis,list);
        }
        list.add(node.getData());
        print(node.getRight(),axis+1,map);
    }
}
