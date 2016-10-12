package practice.ds.ll;

/**
 * Created by aditya on 9/18/16.
 */

public class LinkedListNode {
    private int data;
    private LinkedListNode next;

    public LinkedListNode(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}
