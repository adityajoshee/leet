package practice.ds.ll;

/**
 * Created by aditya on 9/18/16.
 */
public class LinkedList {
    private LinkedListNode head;

    public LinkedListNode getHead() {
        return head;
    }

    public void setHead(LinkedListNode head) {
        this.head = head;
    }

    public void append(int data){
        LinkedListNode t = head;
        if(t==null){
            head = new LinkedListNode(data);
            head.setNext(null);
            return;
        }
        while(t.getNext() !=null){
            t = t.getNext();
        }
        LinkedListNode newnode = new LinkedListNode(data);
        newnode.setNext(null);
        t.setNext(newnode);
    }

    public void print(){
        System.out.println();
        LinkedListNode t = head;
        while(t != null){
            System.out.print(t.getData() +" => ");
            t = t.getNext();
        }
    }
    public void reverse(){
        reverseHelper(head, null);
    }
    private void reverseHelper(LinkedListNode current, LinkedListNode pre){
        if(current==null){
            return;
        }
        if(current.getNext()==null){
            current.setNext(pre);
            head = current;
            return;
        }
        LinkedListNode nxt = current.getNext();
        current.setNext(pre);
        reverseHelper(nxt, current);
    }
    public LinkedListNode reverse2(LinkedListNode n){
        if(n==null || n.getNext()==null){
            return n;
        }
        LinkedListNode t = reverse2(n.getNext());
        n.getNext().setNext(n);
        n.setNext(null);
        return t;
    }
    public LinkedListNode reverseInPair(){
        return reverseInPair(head);
    }
    private LinkedListNode reverseInPair(LinkedListNode n){
        if(n==null || n.getNext()==null){
            return n;
        }
        LinkedListNode rest = n.getNext().getNext();
        LinkedListNode h = n.getNext();
        n.getNext().setNext(n);
        n.setNext(reverseInPair(rest));
        return h;
    }
}
