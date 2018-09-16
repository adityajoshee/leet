package adityajoshee.Y2K18.may.D02;

/**
 * Created by aditya.joshee on 5/2/18.
 * Given a Singly Linked list, Update the second half of the list such that n-th element
 * becomes sum(1st + nth) element, (n-1)st element becomes sum(2nd + n-1st) element and so on.
 * Eg: 2->3->4->5->6 => 2->3->(4+4)->(5+3)->(6+2)
 */

public class LinkedListModifySumHalf {
    public static void main(String[] args) {
        Node head = new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(1,null))))));
        modify(head, new NodeHolder(head, 0), size(head));
        print(head);
    }

    private static void modify(Node right, NodeHolder nodeHolderLeft, int size) {
        if (right==null){
            return;
        }
        modify(right.next, nodeHolderLeft, size);
        if (nodeHolderLeft.index<size/2){
            nodeHolderLeft.index++;
            right.data = right.data+nodeHolderLeft.node.data;
            nodeHolderLeft.node = nodeHolderLeft.node.next;
        }
    }

    private static class NodeHolder{
        Node node;
        int index;
        public NodeHolder(Node n, int index){
            this.node = n;
            this.index = index;
        }
    }

    public static class Node{
        int data;
        Node next;
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    private static void print(Node head){
        while (head!=null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    private static int size(Node head){
        int size = 0;
        while (head!=null){
            size++;
            head = head.next;
        }
        return size;
    }
}
