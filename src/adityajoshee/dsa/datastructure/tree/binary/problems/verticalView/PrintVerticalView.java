package adityajoshee.dsa.datastructure.tree.binary.problems.verticalView;
import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;
import java.util.*;

/**
 * Created by aditya on 10/22/16.
 */
public class PrintVerticalView {
    /*
               20
           6    |      14
       2   |   4 3     |      8
           9           1
*/
    public static void main(String args[]) {
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
        print(tree.getRoot());
    }
    private static void print(BinaryNode node){
        Map<Integer,List<BinaryNode>> orderedMap = new LinkedHashMap<>();
        printHelper(node,0,orderedMap);
        for(Integer key : orderedMap.keySet() ){
            List<BinaryNode> nodes = orderedMap.get(key);
            for (BinaryNode n : nodes) {
                System.out.print(n.getData()+" ");
            }
            System.out.println();
        }
    }

    //preorder traversal with distance from centre (level)
    private static void printHelper(BinaryNode node, int level, Map<Integer,List<BinaryNode>> map){
        if(node==null){
            return;
        }
        List<BinaryNode> nodesAtCurrentLevel = map.get(level);
        if(nodesAtCurrentLevel==null){
            nodesAtCurrentLevel = new LinkedList<>();
            map.put(level, nodesAtCurrentLevel);
        }
        nodesAtCurrentLevel.add(node);
        printHelper(node.getLeft(), level-1, map);
        printHelper(node.getRight(), level+1, map);
    }
}