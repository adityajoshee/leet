package adityajoshee.Y2K19.sep.grab;

/**
 * Created by aditya.joshee on 2019-09-26.
 */
//https://github.com/rishabh115/Interview-Questions/tree/master/Grab#coding

public class AddOneToLL {
    public static void main(String[] args) {
//        Node head = new Node(9, new Node(9, new Node(9)));
//        Node head = new Node(8, new Node(9, new Node(9)));
//        Node head = new Node(8, new Node(9, new Node(8)));
        Node head = new Node(8, new Node(8, new Node(9)));
        int carry = addOne(head);
        if (carry>0){
            head = new Node(carry, head);
        }
        while(head!=null){
            System.out.print(head.val+" -> ");
            head = head.next;
        }
    }

    private static int addOne(Node node) {
        if(node==null){
            return 1;
        }
        int carry = addOne(node.next);
        int res = node.val + carry;
        if(res > 9){
            node.val = 0;
            carry = 1;
        }
        else {
            node.val = res;
            carry = 0;
        }
        return carry;
    }


    static class Node{
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
