public class LinkedListCycleDetect{
	public static void main(String[] args){

	}

	public static Node detectCycle(Node head){
		Node slow= head;
		Node fast= head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(fast==slow) return true;
		}
		return false;
	}
}

class Node{
	int val;
	Node next;

	public Node(int val){
		this.val=val;
		this.next=null;
	}
}