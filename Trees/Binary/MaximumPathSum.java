public class MaximumPathSum{
	public static void main(String[] args){
		Node root=new Node(4);
		root.left=new Node(7);
		root.right=new Node(3);
		root.left.left=new Node(2);
		root.left.right=new Node(8);
		root.left.left.left=new Node(9);
		root.left.left.right=new Node(11);
		root.left.right.left=new Node(21);

		MaximumPathSum maxPathUtil = new MaximumPathSum();
		long[] max= {0};
		long pathSum = maxPathUtil.findMaxPathSum(root, max);
		System.out.println(pathSum + " ");
	}

	public long findMaxPathSum(Node root, long[] max){
		if(root == null ) return 0;


		long left = findMaxPathSum(root.left, max);
		long right= findMaxPathSum(root.right, max);

		max[0]= Math.max(max[0], left+right+ root.val);

		return Math.max(left, right) + root.val;
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