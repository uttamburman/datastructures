import java.util.List;
import java.util.ArrayList;

public class LeftView{
	public static void main(String[] args){
		Node root=new Node(4);
		root.left=new Node(7);
		root.right=new Node(3);
		root.left.left=new Node(2);
		root.left.right=new Node(8);
		root.left.left.left=new Node(9);
		root.left.left.right=new Node(11);
		root.left.right.left=new Node(21);
		LeftView viewUtil=new LeftView();
		viewUtil.getLeftView(root);
		System.out.println();
		viewUtil.getRightView(root);
	}

	public List<Integer> getLeftView(Node root){
		List<Integer> result= new ArrayList<>();
		leftViewUtil(root, result, 0);//Starting from level 0
		for(Integer it: result){
			System.out.print(it+" ");
		}
		return result;
	}

	public List<Integer> getRightView(Node root){
		List<Integer> result= new ArrayList<>();
		rightViewUtil(root, result, 0);//Starting from level 0
		for(Integer it: result){
			System.out.print(it+" ");
		}
		return result;
	}

	public void leftViewUtil(Node root, List<Integer> result, int level){
		if(root == null) return;
		if(level == result.size()){
			result.add(root.val);
		}

		leftViewUtil(root.left, result, level+1);
		leftViewUtil(root.right, result, level+1);
	}

	public void rightViewUtil(Node root, List<Integer> result, int level){
		if(root == null) return;
		if(level == result.size()){
			result.add(root.val);
		}
		rightViewUtil(root.right, result, level+1);
		rightViewUtil(root.left, result, level+1);		
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