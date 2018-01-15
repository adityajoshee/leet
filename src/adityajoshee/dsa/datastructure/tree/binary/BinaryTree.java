package adityajoshee.dsa.datastructure.tree.binary;

import adityajoshee.dsa.datastructure.linkedlist.DLLNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by aditya on 7/25/16.
 */
public class BinaryTree {

    private BinaryNode root;

    public BinaryTree(int rootValue){
        this.root = new BinaryNode(rootValue);
    }

    public BinaryTree(BinaryNode root){
        this.root = root;
    }

    public BinaryNode getRoot() {
        return root;
    }

    public int size(){
        int size = size(root);
        System.out.print("\nSIZE: "+size);
        return size;
    }

    private int size(BinaryNode node){
        if(node==null){
            return 0;
        }
        return size(node.getLeft()) + 1 + size(node.getRight());
    }

    public void inorder(){
        System.out.print("\nINORDER : ");
        inorder(root);
    }
    private void inorder(BinaryNode node){
        if(node==null){
            return;
        }
        inorder(node.getLeft());
        System.out.print(" "+ node.getData()+" ");
        inorder(node.getRight());
    }


    public void preorder(){
        System.out.print("\nPREORDER: ");
        preorder(root);
    }
    private void preorder(BinaryNode node){
        if(node==null){
            return;
        }
        System.out.print(" "+node.getData()+" ");
        preorder(node.getLeft());
        preorder(node.getRight());
    }


    public void postorder(){
        System.out.print("\nPOSTORDER: ");
        postorder(root);
    }
    private void postorder(BinaryNode node){
        if(node==null){
            return;
        }
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.print(" "+node.getData()+" ");
    }



    public void levelOrderTraversal(){
        System.out.print("\nLEVEL ORDER  : ");
        levelOrderTraversal(root);
    }
    private void levelOrderTraversal(BinaryNode node){
        if(node==null){
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(node);
        while(queue.size()>0){
            BinaryNode tempNode = queue.poll();
            System.out.print(" "+tempNode.getData()+" ");
            if(tempNode.getLeft()!=null){
                queue.add(tempNode.getLeft());
            }
            if(tempNode.getRight()!=null){
                queue.add(tempNode.getRight());
            }
        }
    }

    // level of root is 0
    public void printLevel(int level){
        System.out.print("\nLEVEL #"+level+" :");
        printLevel(root,level);
    }
    private void printLevel(BinaryNode node, int level){
        if(node==null){
            return;
        }
        if(level==0){
            System.out.print(" "+node.getData()+" ");
        }
        printLevel(node.getLeft(),level-1);
        printLevel(node.getRight(),level-1);
    }

    public void spiralOrder(){
        System.out.print("\nSPIRAL ORDER:");
        spiralOrder(root);
    }
    private void spiralOrder(BinaryNode node){
        if(node==null){
            return;
        }
        Stack<BinaryNode> stack1 = new Stack<>();
        Stack<BinaryNode> stack2 = new Stack<>();
        stack1.push(node);
        boolean leftOrder = true;

        while (stack1.size()>0 || stack2.size()>0){
            if(stack1.size()>0){
                while(stack1.size()>0){
                    BinaryNode temp = stack1.pop();
                    System.out.print(" "+ temp.getData()+ " ");
                    spiralOrderHelperPushChildrenToOtherStack(leftOrder,stack2,temp);
                }
            }
            else {
                while(stack2.size()>0){
                    BinaryNode temp = stack2.pop();
                    System.out.print(" "+ temp.getData()+ " ");
                    spiralOrderHelperPushChildrenToOtherStack(leftOrder,stack1,temp);
                }
            }
            leftOrder=false;
        }

    }
    private void spiralOrderHelperPushChildrenToOtherStack(boolean leftOrder,Stack<BinaryNode> otherStack, BinaryNode node){
        if(leftOrder){
            if(node.getLeft()!=null)
                otherStack.push(node.getLeft());
            if(node.getRight()!=null)
                otherStack.push(node.getRight());
        }
        else{
            if(node.getRight()!=null)
                otherStack.push(node.getRight());
            if(node.getLeft()!=null)
                otherStack.push(node.getLeft());
        }
    }

    public boolean hasRootToLeafSum(int S){
        return hasRootToLeafSum(root,S);
    }
    private boolean hasRootToLeafSum(BinaryNode node,int sumLeft){
        if(node==null && sumLeft!=0){
            return false;
        }
        if(node==null && sumLeft==0){
            return true;
        }
        if(node!=null && sumLeft==0){
            return false;
        }
        if(node.getRight()==null && node.getLeft()==null && sumLeft==node.getData()){
            return true;
        }
        return hasRootToLeafSum(node.getLeft(),sumLeft-node.getData())||hasRootToLeafSum(node.getRight(),sumLeft-node.getData());
    }


    public BinaryNode lca(int node1, int node2){
        return lca(root, node1, node2);
    }
    private BinaryNode lca(BinaryNode root, int node1, int node2){
        if(root==null){
            return null;
        }
        if(root.getData()==node1 || root.getData()==node2){
            return root;
        }
        BinaryNode lcaLeft = lca(root.getLeft(),node1,node2);
        BinaryNode lcaRight = lca(root.getRight(),node1,node2);

        if(lcaLeft!=null && lcaRight!=null){
            return root;
        }
        return lcaLeft==null?lcaRight:lcaLeft;
    }


    public int height(){
        return height(root);
    }
    private int height(BinaryNode node){
        if(node==null){
            return 0;
        }
        int lh = height(node.getLeft());
        int rh = height(node.getRight());

        return Math.max(lh,rh)+1;
    }


    public int diameter(){
        return diameterHelper(root,new HeightClazz());
    }
    private class HeightClazz{
        int h=0;
    }
    private int diameterHelper(BinaryNode node, HeightClazz heightObject){
        if(node==null){
            return 0;
        }
        HeightClazz lh = new HeightClazz(); // 0, this will become the actual left height only for the last line
        HeightClazz rh = new HeightClazz(); // 0,  this will become the actual right height only for the last line

        int leftDia = diameterHelper(node.getLeft(),lh);
        int rightDia = diameterHelper(node.getRight(),rh);

        int rootDia = 1 + lh.h + rh.h;

        heightObject.h = 1 + Math.max(lh.h,rh.h);

        return Math.max(Math.max(leftDia,rightDia),rootDia);
    }

    public boolean childSumProperty(){
        return childSumProperty(root);
    }
    private boolean childSumProperty(BinaryNode node){
        if(node==null){
            return true;
        }
        if(node.getLeft()==null && node.getRight()==null){ // leaf nodes exempt from sum property
            return true;
        }

        int lval = 0; int rval = 0;
        if(node.getLeft()!=null){
            lval = node.getLeft().getData();
        }
        if(node.getRight()!=null){
            rval = node.getRight().getData();
        }
        return lval+rval!=node.getData() ? false : childSumProperty(node.getLeft()) && childSumProperty(node.getRight());
    }


    public ArrayList<Integer> serialize(){
        System.out.print("\nSerialize:");
        return serialize(root, new ArrayList<Integer>());
    }
    private ArrayList<Integer> serialize(BinaryNode node, ArrayList<Integer> output){
        // Serialize using preorder with '-1' as null marker
        if(node==null){
            output.add(-1);
            return output;
        }
        output.add(node.getData());
        serialize(node.getLeft(),output);
        serialize(node.getRight(),output);
        return output;
    }


    public BinaryNode deserialize(ArrayList<Integer> serializedInput){
        if(serializedInput.size()==0){
            return null;
        }
        if(serializedInput.get(0)==-1){
            serializedInput.remove(0);
            return null;
        }
        BinaryNode node = new BinaryNode();
        node.setData(serializedInput.get(0));
        serializedInput.remove(0);
        node.setLeft(deserialize(serializedInput));
        node.setRight(deserialize(serializedInput));
        return node;
    }


    public void vertical(){
        vertical(root);
    }
    private void vertical(BinaryNode node){

    }


    public void printNodesAtDistanceFromRoot(int distance){
        System.out.print("\nNodes at distance "+distance+" :");
        printLowerNodesAtDistance(root, distance);
    }
    private void printLowerNodesAtDistance(BinaryNode node, int k){
        if(node==null){
            return;
        }
        if(k==0){
            System.out.print(" "+node.getData()+" ");
        }
        printLowerNodesAtDistance(node.getLeft(),k-1);
        printLowerNodesAtDistance(node.getRight(),k-1);
    }



    public void printAncestors(int x){ // or Node x
        System.out.print("\nAncestors of "+x+":");
        printAncestors(root,x);
    }
    private boolean printAncestors(BinaryNode n, int x){
        if(n==null){
            return false;
        }
        if(n.getData()==x){
            return true;
        }
        boolean l = printAncestors(n.getLeft(),x);
        boolean r = printAncestors(n.getRight(),x);

        if(l||r) {
            System.out.print(n.getData() + " ");
            return true;
        }
        return false;
    }

    public DLLNode convertToDoublyLinkedList(){
        DLLNode[] node  = new DLLNode[]{null}; // array of size 1, the null element.
        convertToDLL(root,node);
        DLLNode dllNode = node[0];
        // the node obtained above can be somewhere in the middle of the DLL..so traversing back to head of DLL
        while(dllNode!=null && dllNode.getPrevious()!=null){
            dllNode = dllNode.getPrevious();
        }
        return dllNode;
    }

    // return DLL node which corresponds to the root of the tree (might not be left or right most in DLL.)
    private void convertToDLL(BinaryNode node, DLLNode[] prevDLL){
        if(node==null){
            return;
        }
        convertToDLL(node.getLeft(),prevDLL);
        DLLNode dllNode = new DLLNode(node.getData());

        dllNode.setPrevious(prevDLL[0]);
        if(prevDLL[0]!=null) {
            prevDLL[0].setNext(dllNode);
        }
        prevDLL[0] = dllNode;
        convertToDLL(node.getRight(),prevDLL);
    }



    public static BinaryTree getSampleBST(){
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
        return bst;
    }
}