package datastructure.linkedlist;

import java.util.Random;

public class Demo {
	public static void main(String[] args){
		ListNode L1 = LinkedList.getNew(8);
		ListNode L2 = LinkedList.getNew(3);
		Random rand = new Random();
		int i=4;
		while(i>0){
			LinkedList.appendNode(L1, rand.nextInt(10));
			i--;
		}
		i=7;
		while(i>0){
			LinkedList.appendNode(L2, rand.nextInt(10));
			i--;
		}
		System.out.print("L1: ");LinkedList.printList(L1);
		System.out.println();
		System.out.print("L2: ");LinkedList.printList(L2);
		System.out.println();

		//L1=LinkedList.recursiveReverse(L1);
		//LinkedList.printList(L1);
		System.out.println();
		LinkedList.printList(LinkedList.sumLists(L1, L2));
	}
}
