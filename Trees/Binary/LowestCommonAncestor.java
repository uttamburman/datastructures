public class LowestCommonAncestor{
	public static void main(String[] args){
		Node root=new Node(4);
		root.left=new Node(7);
		root.right=new Node(3);
		root.left.left=new Node(2);
		root.left.right=new Node(8);
		root.left.left.left=new Node(9);
		root.left.left.right=new Node(11);
		root.left.right.left=new Node(21);

		findLCA(root, root.left.left.left, root.left.right.left );
	}

	public static Node findLCA(Node root, Node p, Node q){
		if(root==null || p.val == root.val || q.val== root.val){
			return root;
		}

		Node left = findLCA(root.left,p, q);
		Node right= findLCA(root.right, p, q);

		if(left == null) return right;
		if(right == null) return left;
		else return root;


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