import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList; 

public class VerticalTraversal{
	public static void main(String[] args){
		Node root=new Node(4);
		root.left=new Node(7);
		root.right=new Node(3);
		root.left.left=new Node(2);
		root.left.right=new Node(8);
		root.left.left.left=new Node(9);
		root.left.left.right=new Node(11);
		root.left.right.left=new Node(21);

		VerticalTraversal traversalUtil = new VerticalTraversal();
		traversalUtil.traverse(root);
	}	

	public List<List<Integer>> traverse(Node root){
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		Queue<Tuple> queue=new LinkedList<>();
		//Start with root, 0th level and 0th col
		queue.offer(new Tuple(root, 0, 0));

		while(!queue.isEmpty()){
			Tuple tuple = queue.poll();
			Node node= tuple.node;
			int x=tuple.row;
			int y=tuple.col;

			if(!map.containsKey(x)){
				map.put(x, new TreeMap<>());
			}
			if(!map.get(x).containsKey(y)){
				map.get(x).put(y, new PriorityQueue<>());
			}

			map.get(x).get(y).offer(node.val);
			if(node.left != null) queue.offer(new Tuple(node.left, x-1, y+1));
			if(node.right != null) queue.offer(new Tuple(node.right, x+1, y+1));
 		}

 		List<List<Integer>> verticals = new ArrayList<>();
 		for(TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()){
 			verticals.add(new ArrayList<>());
 			for(PriorityQueue<Integer> pq : levels.values()){
 				while(!pq.isEmpty()){
 					verticals.get(verticals.size()-1).add(pq.poll());
 				}
 			}
 		}
 		return verticals;
	}
}

class Tuple{
	Node node;
	int row, col;

	Tuple(Node node, int row, int col){
		this.node=node;
		this.row=row;
		this.col=col;
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