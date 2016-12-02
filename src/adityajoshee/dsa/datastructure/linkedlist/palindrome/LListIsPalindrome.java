package adityajoshee.dsa.datastructure.linkedlist.palindrome;

/**
 * Created by aditya on 11/21/16.
 */
public class LListIsPalindrome {

    public static void main(String args[]){
        Node prev = null;
        Node head = null;
        Node H = null;
        for (int i = 0; i < 4; i++) {
            head = new Node(i);
            if (prev!=null){
                prev.next = head;
            }
            else{
                H = head;
            }
            prev = head;
        }
        for (int i = 2; i >=0; i--) {
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
        System.out.println(isPalindrome(H, new NodeHolder(H), H.size(), 0));
    }
    private static boolean isPalindrome(Node node, NodeHolder rem, int size, int index){
        if ((size%2==0 && (index==size/2)) || (size%2!=0 && index==size/2)){
            if (size%2!=0){
                rem.val = rem.val.next;
            }
            return true;
        }
        rem.val = rem.val.next;
        boolean res = true;
        res = res && isPalindrome(node.next,rem,size,index+1);
        if (rem.val.data!=node.data){
            return false;
        }
        rem.val = rem.val.next;
        return res;
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
        public NodeHolder(Node v){
            val = v;
        }
    }

}
