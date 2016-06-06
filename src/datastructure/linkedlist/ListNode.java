package datastructure.linkedlist;

import algorithms.dp.LIS;

public class ListNode {
	private int data;
	private ListNode next;
	public ListNode(){
		this.data=0;
		this.next=null;
	}
	public ListNode(int data){
		this.data=data;
		this.next=null;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}


}
