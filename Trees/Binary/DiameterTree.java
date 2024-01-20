public class DiameterTree{
	public static void main(String[] args){
		Node root=new Node(4);
		root.left=new Node(7);
		root.right=new Node(3);
		root.left.left=new Node(2);
		root.left.right=new Node(8);
		root.left.left.left=new Node(9);
		root.left.left.right=new Node(11);
		root.left.right.left=new Node(21);

		DiameterTree util = new DiameterTree();
		int[] max= {0};
		int maxDia= util.findDiameter(root, max);
		System.out.println(maxDia + "");
	}

	public int findDiameter(Node root, int[] max){
		if(root== null) return 0;

		int left= findDiameter(root.left, max);
		int right= findDiameter(root.right, max);
		max[0]= Math.max(max[0], left + right );
		return 1+ Math.max(left,right);
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