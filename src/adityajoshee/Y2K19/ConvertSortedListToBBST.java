package adityajoshee.Y2K19;


//  Created by aditya.joshee on 2019-08-25.


import javafx.util.Pair;

class ConvertSortedListToBBST {
    //  Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    //  Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(-10);
        l.next = new ListNode(-3);
        l.next.next = new ListNode(0);
        l.next.next.next = new ListNode(5);
        l.next.next.next.next = new ListNode(10);
        System.out.println(sortedListToBST(l));
    }
    public static TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return toBst(head, null);
    }
    static TreeNode toBst(ListNode head, ListNode tail){
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        if(head==tail){
            return new TreeNode(head.val);
        }
        Pair<ListNode,ListNode> mids = getLLMid(head, tail);
        TreeNode n = new TreeNode(mids.getValue().val);
        n.left = toBst(head, mids.getKey());
        n.right = toBst(mids.getValue().next, tail);
        return n;
    }
    static Pair<ListNode, ListNode> getLLMid(ListNode head, ListNode tail){
        if(head == null) return null;
        System.out.println(head.val+","+(tail==null?null:tail.val));
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrev = null;
        while(fast!=tail && fast.next!=tail &&  fast.next.next!=tail){
            fast = fast.next.next;
            slowPrev = slow;
            slow = slow.next;
        }
        System.out.println(slow.val);
        return new Pair<>(slowPrev,slow);
    }
}
