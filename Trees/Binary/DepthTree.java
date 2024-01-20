public class DepthTree{
	public static void main(String[] args){
		Node root=new Node(4);
		root.left=new Node(7);
		root.right=new Node(3);
		root.left.left=new Node(2);
		root.left.right=new Node(8);
		root.left.left.left=new Node(9);
		root.left.left.right=new Node(11);
		root.left.right.left=new Node(21);

		DepthTree depthFinder = new DepthTree();
		int depth = depthFinder.findDepth(root);
		System.out.println(depth + "");
	}

	public int findDepth(Node root){
		if(root == null) return 0;

		int left=  findDepth(root.left);
		int right=  findDepth(root.right);

		return 1+Math.max(left,right);
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