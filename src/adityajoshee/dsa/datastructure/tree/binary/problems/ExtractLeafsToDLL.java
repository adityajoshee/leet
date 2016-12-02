package adityajoshee.dsa.datastructure.tree.binary.problems;

import adityajoshee.dsa.datastructure.linkedlist.DLLNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;
import adityajoshee.dsa.datastructure.tree.binary.BinaryTree;

/**
 * Created by aditya on 10/20/16.
 */
public class ExtractLeafsToDLL {
/*
               20
         6         14
     2      4    6      8

*/
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree(20);
        BinaryNode A = tree.getRoot();

        BinaryNode B = A.setLeft(6);
        B.setLeft(2);
        B.setRight(4);
        BinaryNode C = A.setRight(14);
        C.setLeft(6);
        C.setRight(8);
        LastDLLNode last = new LastDLLNode();
        DLLNode dllNode= convertAndPrintDLL(tree.getRoot(), last);
        print(dllNode);
    }
    private static DLLNode convertAndPrintDLL(BinaryNode node, LastDLLNode lastDllNode){
        if(node==null){
            return lastDllNode.node;
        }
        if(node.getLeft()==null && node.getRight()==null){
            // add to DLL
            DLLNode newDllNode = new DLLNode(node.getData());
            newDllNode.setPrevious(lastDllNode.node);
            newDllNode.setNext(null);
            if(lastDllNode.node!=null){
                lastDllNode.node.setNext(newDllNode);
            }
            lastDllNode.node = newDllNode;
        }
        convertAndPrintDLL(node.getLeft(), lastDllNode);
        convertAndPrintDLL(node.getRight(), lastDllNode);
        return lastDllNode.node;
    }

    private static void print(DLLNode node){
        while(node!=null){
            System.out.print(node.getData()+" ");
            node = node.getPrevious();
        }
    }
    //req. to change reference between recursive calls.
    static class LastDLLNode{
        DLLNode node;
    }
}
