import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
public class LevelOrderTraversal{
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

		LevelOrderTraversal traversalUtil = new LevelOrderTraversal();
		List<List<Integer>> ans = traversalUtil.levelOrderTraversal(root);
		for(List<Integer> level: ans){
			for(Integer it: level){
				System.out.print(it+", ");
			}
			System.out.println();
		}

	}

	public List<List<Integer>> levelOrderTraversal(Node root){
		List<List<Integer>> levelOrderList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			List<Integer> subList = new ArrayList<>();			
			int levelNum= queue.size();
			for(int i=0;i<levelNum;i++){
				Node node=queue.peek();
				if(node.left!=null) queue.offer(node.left);
				if(node.right!=null) queue.offer(node.right);
				subList.add(queue.poll().val);
			}
			levelOrderList.add(subList);
		}
		return levelOrderList;
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