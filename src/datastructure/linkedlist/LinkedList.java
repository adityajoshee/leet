package linkedlist;

public class LinkedList {
	public static ListNode getNew(int data){
		ListNode n = new ListNode(data);
		return n;
	}
	public static ListNode search(ListNode root,int data){
		while(root!=null){
			if(root.getData()==data)
				return root;
			root=root.getNext();
		}
		return null;
	}
	public static boolean appendNode(ListNode root,int data){
		ListNode n = new ListNode(data);
		if(root==null){
			System.out.println("ERROR: Root Node is NULL !");
			return false;	
		}
		while(root.getNext()!=null){
			root=root.getNext();
		}
		root.setNext(n);
		return true;
	}
	public static void printList(ListNode root){
		while(root!=null){
			System.out.print(root.getData()+" ");
			root=root.getNext();
		}
	}
	public static ListNode sumLists(ListNode L1,ListNode L2){
		int size1=countNodes(L1);
		int size2=countNodes(L2);
		
		if(size1>size2){
			while(size1!=size2){
				ListNode n=new ListNode(0);
				n.setNext(L2);
				L2=n;
				size2++;
			}
		}
		else{
			while(size1!=size2){
				ListNode n=new ListNode(0);
				n.setNext(L1);
				L1=n;
				size1++;
			}
		}
		ListNode result = new ListNode();
		int finalCarry=add(L1,L2,result);
		if(finalCarry>0){
			ListNode head = new ListNode(finalCarry);
			head.setNext(result);
			return head;
		}
		return result;
	}
	private static int add(ListNode L1,ListNode L2,ListNode current){
		if(L1==null || L2==null)
			return 0;
		ListNode node = new ListNode();
		if(L1.getNext()!=null)
			current.setNext(node);
		int carry =add(L1.getNext(),L2.getNext(),node);
		int sum =carry+L1.getData()+L2.getData();
		carry=sum/10;
		sum=sum%10;
		current.setData(sum);
		return carry;
	}
	public static ListNode recursiveReverse(ListNode head){
		ListNode result;
		if(!(head!=null && head.getNext()!=null)){
			return head;
		}
		result=recursiveReverse(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		return result;
	}
	public static int countNodes(ListNode head){
		int i=0;
		while(head!=null){
			i++;
			head=head.getNext();
		}
		return i;
	}
}
