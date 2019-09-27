package adityajoshee.Y2K19.sep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aditya.joshee on 2019-09-15.
 */
public class RemoveZeroSumSubLinkedList {
    public static void main(String[] args) {
        ListNode n = removeZeroSumSublists(new ListNode(1, new ListNode(3, new ListNode(2, new ListNode(-3, new ListNode(-2, new ListNode(5, new ListNode(5, new ListNode(-5, new ListNode(1))))))))));
        //ListNode n = removeZeroSumSublists(new ListNode(2, new ListNode(2, new ListNode(-2, new ListNode(1, new ListNode(-1, new ListNode(-1)))))));// new ListNode(5, new ListNode(-5, new ListNode(1))))))))));
        while(n!=null){
            System.out.print(n.val+" ->> ");
            n = n.next;
        }
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        // use hashmap to store prefix sum and the right node ref
        // whenever we find same value again, we can delete LL(i,j) incl from LL.

        ListNode node = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int psum = 0;
        while(node!=null){
            psum = psum + node.val;
            ListNode samePSumNode = map.get(psum);

            if(psum==0 || samePSumNode!=null){ // a node previously existed with same presum
                ListNode temp;
                if(psum==0){ // move head to next of curr node
                    temp = head;
                    head = node.next;
                }
                else{
                    temp = samePSumNode.next;
                    samePSumNode.next = node.next; // del from next of that node till curr node.
                }

                // remove all stale entries from map
                int tsum = psum;
                while(temp.next!=node.next){
                    tsum = tsum+temp.val;
                    map.remove(tsum);
                    temp = temp.next;
                }
            }
            else{
                map.put(psum, node);
            }
            node = node.next;
        }
        return head;
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode next) { val = x; this.next = next;}
    }
}
