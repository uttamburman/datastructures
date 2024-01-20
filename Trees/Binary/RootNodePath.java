import java.util.List;
import java.util.ArrayList;
public class RootNodePath{
	public static void main(String[] args){
		Node root=new Node(4);
		root.left=new Node(7);
		root.right=new Node(3);
		root.left.left=new Node(2);
		root.left.right=new Node(8);
		root.left.left.left=new Node(9);
		root.left.left.right=new Node(11);
		root.left.right.left=new Node(21);
		int input=11;
		List<Integer> ans= findRootNodePath(root, input);

		for(Integer it: ans){
			System.out.println(it+"\n|");
		}
	}

	public static List<Integer> findRootNodePath(Node root, int input){
		List<Integer> path = new ArrayList<>();
		pathUtil(root, path, input);
		return path;
	}

	public static boolean pathUtil(Node node, List<Integer> path, int input){
		if(node == null)return false;
		path.add(node.val);
		if(node.val== input) return true;

		boolean left = pathUtil(node.left, path, input);
		boolean right = pathUtil(node.right, path, input);
		if(left || right){
			return true;
		}

		path.remove(path.size()-1);

		return false;

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