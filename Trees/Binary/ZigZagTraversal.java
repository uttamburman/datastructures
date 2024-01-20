import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ZigZagTraversal{
	public static void main(String[] args){
		Node root=new Node(4);
		root.left=new Node(7);
		root.right=new Node(3);
		root.left.left=new Node(2);
		root.left.right=new Node(8);
		root.left.left.left=new Node(9);
		root.left.left.right=new Node(11);
		root.left.right.left=new Node(21);

		ZigZagTraversal traversalUtil = new ZigZagTraversal();
		List<List<Integer>> ans = traversalUtil.zigzagTraversal(root);
		for(List<Integer> level:ans){
			for(Integer it: level){
				System.out.print(it+" ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> zigzagTraversal(Node root){
		Queue<Node> queue= new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		boolean flag = true;
		queue.offer(root);

		while(!queue.isEmpty()){
			int level = queue.size();
			List<Integer> sublist =new ArrayList<>();
			for(int i=0; i < level ; i++){
				Node node = queue.peek();
				if(node.left!=null) queue.offer(node.left);
				if(node.right!=null) queue.offer(node.right);
				if(flag){
					sublist.add(queue.poll().val);
				}else{
					sublist.add(0,queue.poll().val);
				}
			}
			flag=!flag;
			result.add(sublist);
		}
		return result;
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