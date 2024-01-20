import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;


public class TopView{
	public static void main(String[] args){
		Node root=new Node(4);
		root.left=new Node(7);
		root.right=new Node(3);
		root.left.left=new Node(2);
		root.left.right=new Node(8);
		root.left.left.left=new Node(9);
		root.left.left.right=new Node(11);
		root.left.right.left=new Node(21);

		TopView traversalUtil = new TopView();
		traversalUtil.traverse(root);
	}

	public List<Integer> traverse(Node root){
		Map<Integer, Integer> map=new HashMap<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(root,0));

		while(!queue.isEmpty()){
			Pair pair= queue.poll();
			Node node= pair.node;
			int row= pair.row;

			if(!map.containsKey(row)) map.put(row,node.val);
			if(node.left!=null) queue.offer(new Pair(node.left, row-1));
			if(node.right!=null) queue.offer(new Pair(node.right, row+1));
		}
		List<Integer> topView = new ArrayList<>();
		for(Integer it: map.values()){
			System.out.print(it+ " ");
			topView.add(it);
		}

		return topView;
	}

}

class Pair{
	Node node;
	int row;
	public Pair(Node node, int row){
		this.node = node;
		this.row = row;
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