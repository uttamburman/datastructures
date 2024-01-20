import java.util.List;
import java.util.ArrayList;

public class BoundaryView{
	public static void main(String[] args){
		Node root=new Node(4);
		root.left=new Node(7);
		root.right=new Node(3);
		root.left.left=new Node(2);
		root.left.right=new Node(8);
		root.left.left.left=new Node(9);
		root.left.left.right=new Node(11);
		root.left.right.left=new Node(21);

		BoundaryView viewUtil= new BoundaryView();
		viewUtil.boundaryView(root);
	}

	public boolean isLeafNode(Node node){
		return node.left==null && node.right==null;
	}

	public List<Integer> boundaryView(Node root){
		List<Integer> result = new ArrayList<>();
		findLeftView(root, result);
		findBottomView(root, result );
		findRightView(root, result );
		for(Integer it: result){
			System.out.print(it+" ");
		}
		return result;
	}

	public void findLeftView(Node root, List<Integer> result){
		Node cur= root;
		cur= cur.left;
		while(cur != null){
			if(!isLeafNode(cur)) result.add(cur.val);
			if(cur.left!=null) cur=cur.left;
			else cur=cur.right;
		}		
	}

	public void findRightView(Node root, List<Integer> result){
		List<Integer> rightView = new ArrayList<>();
		Node cur=root;
		cur=cur.right;
		while(cur != null){
			if(!isLeafNode(cur)) rightView.add(cur.val);
			if(cur.right != null) cur=cur.right;
			else cur = cur.left;
		}
		//Add in result from bottom
		for(int i = rightView.size()-1; i >= 0; --i){
			result.add(rightView.get(i));
		}
	}

	public void findBottomView(Node root, List<Integer> result){
		if(isLeafNode(root)){
			result.add(root.val);
			return;
		}

		if(root.left != null) findBottomView(root.left, result);
		if(root.right != null) findBottomView(root.right, result);
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