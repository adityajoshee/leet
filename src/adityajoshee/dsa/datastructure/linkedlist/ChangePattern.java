package adityajoshee.dsa.datastructure.linkedlist;

/**
 * Created by adityajoshee on 08/05/16.
 */

//Given a linked list eg : 1->2->3->4->5->6, make the following changes 1->6->2->5->3->4

public class ChangePattern {

    public static void main(String args[]){

        ListNode list = LinkedList.getNew(1);

        for(int i=2;i<=6;i++){
            LinkedList.appendNode(list, i);
        }

        LinkedList.printList(list);
        System.out.println();

        change(list);
        LinkedList.printList(list);

    }

    private static void change(ListNode list){
        while(list!=null && list.getNext()!=null){
            ListNode last = getLastNodeAndMakeNull(list);
            ListNode temp = list.getNext();
            list.setNext(last);
            last.setNext(temp);
            list=temp;
        }
    }

    private static ListNode getLastNodeAndMakeNull(ListNode list){
        if(list==null){
           return null;
        }
        ListNode prev=list;
        while(list.getNext()!=null){
            prev = list;
            list=list.getNext();
        }
        prev.setNext(null);
        return list;
    }
}
