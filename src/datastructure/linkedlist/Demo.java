package datastructure.linkedlist;

import java.util.Random;

public class Demo {
	public static void main(String[] args){
		ListNode L1 = LinkedList.getNew(8);
		ListNode L2 = LinkedList.getNew(3);
		Random rand = new Random();
		int i=4;
		while(i>0){
			LinkedList.appendNode(L1,i);
			i--;
		}
        while(i<=2){
            LinkedList.appendNode(L1,i);
            i++;
        }
        //LinkedList.appendNode(L1,8);



        i=7;
		while(i>0){
			LinkedList.appendNode(L2, rand.nextInt(10));
			i--;
		}
		System.out.print("L1: ");LinkedList.printList(L1);
		System.out.println();
		System.out.print("L2: ");LinkedList.printList(L2);
		System.out.println();
		System.out.println("\n******************************************");

		LinkedList.printList(LinkedList.reverse(L2));
		System.out.println("\n******************************************");

		LinkedList.printList(LinkedList.sumLists(L1, L2));
		System.out.println("\n******************************************");

		LinkedList.printList(LinkedList.addTwoLists(L1,L2));

        System.out.println("\nAlternately Merged Lists: ");LinkedList.printList(LinkedList.mergeAltLoop(L1,L2));

		//L1=LinkedList.recursiveReverse(L1);
		//LinkedList.printList(L1);
		System.out.println();

        System.out.println("\n******************************************");

        System.out.println(LinkedList.isPalindrome(L1));

		ListNode L3 = LinkedList.getNew(1);
		int x=2;
		while(x<=8){
			LinkedList.appendNode(L3,x);
			x++;
		}
		LinkedList.printList(L3);
		ListNode xx = LinkedList.reverseK(L3,3);
		System.out.println();
		LinkedList.printList(xx);

	}
}
