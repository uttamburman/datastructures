import java.util.Stack;

public class PreOrderIterative{
	public static void main(String[] args){
		Node root=new Node(4);
		root.left=new Node(7);
		root.right=new Node(3);
		root.left.left=new Node(2);
		root.left.right=new Node(8);
		root.right.left=new Node(16);
		root.right.right=new Node(19);
		root.left.left.left=new Node(2);
		root.left.left.right=new Node(11);
		root.left.right.left=new Node(21);
		preorderTraversal(root);
	}

	public static void preorderTraversal(Node root){
		Stack<Node> st=new Stack<>();
		st.push(root);
		while(!st.isEmpty()){
			Node node=st.pop();
			System.out.println(node.val+ ", ");			
			if(node.right!=null) st.push(node.right);
			if(node.left!=null) st.push(node.left);
		}
	}
}

class Node{
		int val;
		Node left;
		Node right;

		Node(int val){
			this.val=val;
			left=null;
			right=null;
		}
}