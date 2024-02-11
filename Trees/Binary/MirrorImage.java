public class MirrorImage {
    public static void main(String args[]) {
      Node root = new Node(1);
      root.left = new Node(2);
      root.right=new Node(3);
      root.left.left=new Node(4);
      root.left.right=new Node(5);
      root.right.left=new Node(6);
      root.right.right=new Node(7);
      root.print("", root, false);
     
      createMirrorImage(root);
      
      root.print("", root, false);
      
    }
    
    public static void createMirrorImage(Node root){
        if(root== null) return;
        
        createMirrorImage(root.left);
        createMirrorImage(root.right);
        
        Node temp = root.left;
        root.left = root.right;
        root.right= temp;
        
    }
    
    
      
}

class Node{
    int val;
    Node left;
    Node right;
    
    Node(int val){
        this.val=val;
        this.left= null;
        this.right=null;
    }
    
    public void print() {
        print("", this, false);
    }

    public void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.val);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

}

/**
 *    1
  2      3
4   5  6   7



    1
  3    2
6  7  5   4 


 * */