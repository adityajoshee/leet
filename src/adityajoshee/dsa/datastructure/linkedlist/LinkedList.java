package adityajoshee.dsa.datastructure.linkedlist;

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

	public static int countNodes(ListNode head){
		int i=0;
		while(head!=null){
			i++;
			head=head.getNext();
		}
		return i;
	}

    public static boolean isPalindrome(ListNode head){
        if(head!=null){
            ListNode p= getMiddleNode(head);
            if(LinkedList.countNodes(head)%2!=0){
                p=p.getNext();
            }
            if(isPalindromeHelper(head,p)!=null){
                return true;
            }
            return false;
        }
        return true;
    }

    private static ListNode isPalindromeHelper(ListNode head, ListNode p) {
        if(p==null){
            return head;
        }
        head=isPalindromeHelper(head,p.getNext());

        if(head.getData()==p.getData()){
            return (head.getNext()!=null)?head.getNext():null;
        }

        return head;
    }

    public static ListNode getMiddleNode(ListNode head){
        int size= LinkedList.countNodes(head);
        ListNode p=head;
            for(int i=0;i<size/2;i++){
                p=p.getNext();
            }
        return p;
    }

    /*
    Merge two linked lists alternately using recursion
     */
    public static ListNode mergeAltRec(ListNode p,ListNode q){
        if(p==null)
            return q;
        if(q==null)
            return p;
        ListNode t = p.getNext();
        p.setNext(q);
        mergeAltRec(q,t);
        return  p;
    }

    /*
    Merge two linked lists alternately using iteration
    */
    public static ListNode mergeAltLoop(ListNode p , ListNode q){
        ListNode head = p;
        ListNode t=null;
        while(p!=null && q!=null){
            t=p.getNext();
            p.setNext(q);
            p=q;
            q=t;
        }
        return head;
    }

	// can't change original lists
	public static  ListNode addTwoLists(ListNode a, ListNode b){
		int sizeA = LinkedList.countNodes(a);
		int sizeB = LinkedList.countNodes(b);
		ListNode tempA = a;
		ListNode tempB = b;
		ListNode biggerList = null;
		if(sizeA>sizeB){
			biggerList = a;
			int diff = sizeA-sizeB;
			while(diff!=0){
				tempA = tempA.getNext();
				diff--;
			}
		}
		else if(sizeB>sizeA){
			biggerList = b;
			int diff = sizeB - sizeA;
			while(diff!=0){
				tempB = tempB.getNext();
				diff--;
			}
		}

		// Now tempA and tempB both have same size;
		CarryWrapper carry = new CarryWrapper();
		ListNode tempSumList = addListsWithSameSize(tempA,tempB,carry);
		if(biggerList==null){
			if(carry.val>0){
				ListNode n = new ListNode(carry.val);
				n.setNext(tempSumList);
				return  n;
			}
			else{
				return tempSumList;
			}
		}
		else{
			// TODO
		}
		return null;
	}
	public static ListNode addListsWithSameSize(ListNode x, ListNode y, CarryWrapper carry){
		if(x==null || y==null){
			return null;
		}
		ListNode t = addListsWithSameSize(x.getNext(),y.getNext(),carry);
		ListNode n = new ListNode();
		int data = (x.getData()+y.getData()+carry.val)%10;
		carry.val = (x.getData()+y.getData()+carry.val)/10;
		n.setData(data);
		n.setNext(t);
		return n;
	}

	public static ListNode reverse(ListNode list)
	{
		if (list == null) return null; // first question

		if (list.getNext() == null) return list; // second question

		ListNode x = reverse(list.getNext());
		list.getNext().setNext(list);
		list.setNext(null);
		return x;
	}

	// return new head
	public static ListNode reverseInPair(ListNode n){
		if(n==null || n.getNext()==null){
			return n;
		}
		ListNode rest = n.getNext().getNext();
		ListNode h = n.getNext();
		n.getNext().setNext(n);
		n.setNext(reverseInPair(rest));
		return h;
	}

	public static ListNode reverseK(ListNode n, int k){
		if(n==null || n.getNext()==null){
			return n;
		}
		int i=0;
		ListNode curr = n;
		ListNode prev = null;
		while(n!=null && i++<k){
			ListNode t = n.getNext();
			n.setNext(prev);
			prev = n;
			n = t;
		}
		curr.setNext(reverseK(n,k));
		return prev;
	}
}
