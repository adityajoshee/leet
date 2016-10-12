package datastructure.linkedlist.doubly;

/**
 * Created by aditya on 9/18/16.
 */
// bst (or any binary tree, but in bst it will be sorted automatically)
// to dll (will generate a sorted dll)
public class TreeToDLL {
    public static void main(String args[]){
        TreeNode t = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t1 = new TreeNode(1);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t8 = new TreeNode(8);
        t.setLeft(t3);
        t3.setLeft(t1);
        t.setRight(t7);
        t7.setRight(t9);
        t9.setLeft(t8);
        DllNode dll = convert(t);
        dll.print();
    }
    static class DllNode{
        int data;
        DllNode next;
        DllNode prev;

        public DllNode(int data) {
            this.data = data;
        }
        public DllNode() {
        }
        public int getData() {
            return data;
        }
        public DllNode getPrev() {
            return prev;
        }
        public void setPrev(DllNode prev) {
            this.prev = prev;
        }

        public void setData(int data) {
            this.data = data;
        }
        public DllNode getNext() {
            return next;
        }
        public void setNext(DllNode next) {
            this.next = next;
        }
        public void print(){
            DllNode t = this;
            while(t!=null){
                System.out.print(t.getData()+"->");
                t = t.getNext();
            }
        }
    }
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode setLeft(TreeNode left) {
            this.left = left;
            return this;
        }

        public TreeNode getRight() {
            return right;
        }

        public TreeNode setRight(TreeNode right) {
            this.right = right;
            return this;
        }
    }

    private static DllNode convert(TreeNode t){
        DllNode d =convert(t,new PreviousDLLNode());
        while(d.prev!=null){
            d = d.prev;
        }
        return d;
    }
    private static DllNode convert(TreeNode t, PreviousDLLNode d){
        if(t==null) return null;
        convert(t.getLeft(),d);
        DllNode dn = new DllNode(t.getData());
        if(d.val!=null){
            d.val.setNext(dn);
        }
        dn.setPrev(d.val);
        d.val = dn;
        convert(t.getRight(),d);
        return dn; // this node will be in the middle of the dll.
    }
    private static class PreviousDLLNode{
        DllNode val;
    }
}
