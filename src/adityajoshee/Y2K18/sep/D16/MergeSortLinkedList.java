package adityajoshee.Y2K18.sep.D16;

public class MergeSortLinkedList {

    public static void main(String[] args) {
        Node ll = createSampleList();
        sort(ll);
    }

    private static Node sort(Node node){
        if (node==null || node.next==null){ // 0 or 1 element list
            return node;
        }

        Node mid = getMidNode(node);
        sort(mid.next); // 2nd half
        mid.next=null;
        sort(node); // 1st half

        return mergeSortedLists(node, mid);
    }

    private static Node mergeSortedLists(Node l1, Node l2) {
        Node mergedList = null;
        Node head = null;

        while (l1!=null && l2!=null){
            if (mergedList==null){
                mergedList = new Node();
                head = mergedList;
            }

            else {
                Node newNode = new Node();
                mergedList.next = newNode;
            }
            Node newNode = new Node();

            if (l1.data<l2.data){
                newNode.data=l1.data;
            }
            else {
                newNode.data=l2.data;
            }
        }
        return head;
    }

    private static Node getMidNode(Node node) {
        Node p1 = node;
        Node p2 = node;
        while (p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    static class Node{
        int data;
        Node next;
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
        public Node(){

        }
    }

    private static Node createSampleList(){
        return new Node(3, new Node(1, new Node(2, new Node(0, null))));
    }

}