package adityajoshee.dsa.datastructure.tree.binary.problems;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by aditya on 12/2/16.
 */

/*
Bottom view cannot be done with extra storage (using a treemap)
treemap used to print nodes from left to right.
 */
public class BottomView {
    public static void main(String args[]){
        BinaryNode root = new BinaryNode(5);
        root.setLeft(3).setLeft(1);
        BinaryNode r = root.setRight(8);
        r.setLeft(6).setLeft(7).setRight(10);
        r.setRight(9).setRight(0);
        TreeMap<Integer,MapNodeData> map = new TreeMap<>();
        print(root, 0, 0, map);
        for (MapNodeData i: map.values()){
            System.out.print(" "+i.val+" ");
        }
    }

    private static void print(BinaryNode node, int currAxis, int currDepth, Map<Integer,MapNodeData> mapAxialVsDepth){
        if (node==null){
            return;
        }
        MapNodeData mapNode = mapAxialVsDepth.get(currAxis);
        if (mapNode==null) {
            mapNode = new MapNodeData(node.getData(), currDepth);
            mapAxialVsDepth.put(currAxis, mapNode );
        }
        else if (currDepth>mapNode.depth){
            mapNode.val = node.getData();
            mapNode.depth = currDepth;
        }
        print(node.getLeft(), currAxis-1, currDepth+1, mapAxialVsDepth);
        print(node.getRight(), currAxis+1, currDepth+1, mapAxialVsDepth);
    }

    private static class MapNodeData{
        int val;
        int depth;
        public MapNodeData(int v, int d){
            val = v;
            depth = d;
        }
    }
}
