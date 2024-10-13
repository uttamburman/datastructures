import java.util.Map;
import java.util.HashMap;

public class LinkedListIntersection{
	public static void main(String[] args){
		ListNode headA = new ListNode(4);
		headA.next = new ListNode(1);
		headA.next.next = new ListNode(8);
		headA.next.next.next = new ListNode(4);
		headA.next.next.next.next = new ListNode(5);


		ListNode headB = new ListNode(5);
		headB.next = new ListNode(6);
		headB.next.next = new ListNode(1);
		headB.next.next = headA.next.next = new ListNode(8);

		//ListNode ans1 = findIntersectionHashMap(headA, headB);

		ListNode ans2 = findIntersectionCollision(headA, headB);

		//System.out.println(ans1.val);
		System.out.println(ans2.val);

	}

	public static ListNode findIntersectionCollision(ListNode headA, ListNode headB){
		ListNode temp1 = headA;
		ListNode temp2 = headB;

		while(temp1 != temp2){
			temp1 = temp1 == null ? headB : temp1.next;
			temp2 = temp2 == null ? headA : temp2.next;
		}

		return temp1;
	}

	public static ListNode findIntersectionHashMap(ListNode headA, ListNode headB){
		ListNode temp1 = headA;

		Map<ListNode, Integer> nodeMap = new HashMap<>();
		while(temp1 != null){
			nodeMap.put(temp1,1);
			temp1= temp1.next;
		}

		temp1 = headB;
		while(temp1 != null){
			if(nodeMap.containsKey(temp1)) return temp1;
			temp1= temp1.next;
		}

		return null;
	}
}

class ListNode{
	int val;
	ListNode next;

	public ListNode(int val){
		this.val= val;
		this.next= null;
	}
}