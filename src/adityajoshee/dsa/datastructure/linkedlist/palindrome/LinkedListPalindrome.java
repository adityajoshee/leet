package adityajoshee.dsa.datastructure.linkedlist.palindrome;

/**
 * Created by aditya.j on 5/4/17.
 */
public class LinkedListPalindrome {
    public static void main(String args[]){
        Node prev = null;
        Node head = null;
        Node H = null;
        for (int i = 0; i < 2; i++) {
            head = new Node(i);
            if (prev!=null){
                prev.next = head;
            }
            else{
                H = head;
            }
            prev = head;
        }
        for (int i = 1; i >=0; i--) {
            head = new Node(i);
            if (prev!=null){
                prev.next = head;
            }
            else{
                H = head;
            }
            prev = head;
        }

        H.print();
        System.out.println(isPalindrome(H));
    }


    private static boolean isPalindrome(Node node){
        NodeHolder left = new NodeHolder();
        left.val = node;
        return check(node, left);
    }

    // b->b
    private static boolean check(Node right, NodeHolder left){
        if (right==null){
            return true;
        }
        boolean b = check(right.next, left);  // taking 'right' to rightmost node

        if (b && left.val.data==right.data){
            System.out.println("c");
            left.val = left.val.next;
            return true;
        }
        return false;
    }



    private static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }

        public void print(){
            Node n = this;
            do{
                System.out.print(n.data+" -> ");
                n = n.next;
            }while(n!=null);
            System.out.println();
        }

        public int size(){
            int c = 0;
            Node n = this;
            while(n!=null){
                c++;
                n=n.next;
            }
            return c;
        }
    }

    private static class NodeHolder{
        Node val;
    }
}
