package adityajoshee.Y2K18.may.D23;

/**
 * Created by aditya.joshee on 5/23/18.
 *
 * Given an SLL, mutate the list such that the prime numbers are moved to the end while
 * composite numbers are shifted to the beginning of the list. The relative order of the
 * prime and non-prime numbers should be preserved.
 */
public class LinkedListMoveToEndMaintainOrder {
    public static void main(String[] args) {

        Node node = new Node(1,
                new Node(9,
                new Node(3,
                new Node(4,
                new Node(5,
                new Node(7,
                new Node(8,
                new Node(2, null))))))));

        Node newHead = rearrange(node);
        while (newHead!=null){
            System.out.println(newHead.data + "-> ");
            newHead = newHead.next;
        }

    }

    private static Node rearrange(Node node) {
        Node lastNode = null;
        Node currNode = node;
        int count = 0;

        while (currNode!=null){
            lastNode = currNode;
            currNode = currNode.next;
            count++;
        }

        currNode = node;
        Node head = node;
        Node prevNode = null;
        Node nextNode = currNode.next;
        while (count>0){
            count--;
            if (isPrime(currNode.data)){
                //move to end
                lastNode.next = currNode;
                nextNode = currNode.next;
                currNode.next = null;

                //set prev node next to tempNode next
                if (prevNode!=null){
                    prevNode.next = nextNode;
                }
                else {
                    //if no prev then update head to currNext next
                    head = nextNode;
                }
                lastNode = currNode;
                currNode = nextNode;
            }
            else {
                //simple go to next node and update prev to curr node.
                prevNode = currNode;
                currNode = currNode.next;
            }
        }
        return head;
    }

    public static class Node{
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static boolean isPrime(int n){
        if (n<4){
            return true;
        }
        double i = 2;
        double maxFactor = Math.floor(Math.sqrt(n));
        while (i <= maxFactor){
            if (n%i==0){
                return false;
            }
            i++;
        }
        return true;
    }
}
