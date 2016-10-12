package datastructure.linkedlist;

/**
 * Created by aditya on 8/15/16.
 */
public class DLLNode {

    private int data;
    private DLLNode previous;
    private DLLNode next;

    public DLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public void printSuccessors(){
        System.out.print("\nDLL: ");
        DLLNode node = this;
        while(node!=null){
            System.out.print(node.data+"<->");
            node=node.getNext();
        }
    }
}
