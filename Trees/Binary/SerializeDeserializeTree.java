import java.util.Queue;
import java.util.LinkedList;

public class SerializeDeserializeTree{
    public static void main(String[] args){
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(7);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(8);
        root.left.left.left=new TreeNode(9);
        root.left.left.right=new TreeNode(11);
        root.left.right.left=new TreeNode(21);

        System.out.println("Print TreeNode");
        printTree(root);
        System.out.println();

        Codec codec = new Codec();
        String encodedString = codec.serialize(root);
        System.out.println("Print Encoded String");
        System.out.println(encodedString);

        TreeNode decodedRoot = codec.deserialize(encodedString);
        System.out.println("Print Decoded TreeNode");
        printTree(decodedRoot);
        System.out.println();
    }

    public static void printTree(TreeNode node){
        if(node== null) return;

        printTree(node.left);
        System.out.print(node.val+", ");
        printTree(node.right);

    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
 
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> qu= new LinkedList<>();
        qu.add(root);
        StringBuilder treeString= new StringBuilder();
        while(!qu.isEmpty()){
            TreeNode node = qu.poll();
            if(node == null){
                treeString.append("n ");
                continue;
            }
            treeString.append(node.val+" ");
            qu.add(node.left);
            qu.add(node.right);
        }
        
        return treeString.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] values= data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for(int i=1;i<values.length;i++){
            TreeNode parent = q.poll();
            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left= left;
                q.add(left);
            }
            if(!values[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right= right;
                q.add(right);
            }
        }
        return root;
    }
}



// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;