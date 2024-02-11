public class FlattenLinkedList{
	public static void main(String[] args){

	}

	public static Node flattenLinkedList(Node head){

        Node tempHead = head;

        while(tempHead!=null){            
            if(tempHead.child!=null){
                Node last = tempHead.next;
                tempHead.next = tempHead.child;
                tempHead.child = null;
                tempHead.next.prev = tempHead;
                tempHead = tempHead.next;
                Node nextNodeHolder = tempHead;
                while(nextNodeHolder.next!=null){
                    nextNodeHolder = nextNodeHolder.next;
                }
                nextNodeHolder.next = last;
                if(last!=null){
                    last.prev = nextNodeHolder;
                }
            }else{
                tempHead = tempHead.next;
            }
        }
        return head;
	}
}

class Node{
	int val;
	Node next;
	Node child;
	Node prev;

	public Node(int val){
		this.val=val;
		next=null;
		child=null;
		prev=null;
	}
}