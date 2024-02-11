public class TrieAddSearch{
	public static void main(String[] args){
		Trie trie=new Trie();
	}
}

class Trie{
	Node root;

	public Trie(){
		root= new Node();
	}

	public void insert(String word){
		//TODO new code for loop-> check --> insert
	}

	public boolean startsWith(String prefix){
		return false;
	}

	public boolean search(String word){
		//TODO new code loop -> check --> boolean
	}
}

class Node{
	Node[] links;
	boolean flag;
	
	public Node(){
		links= new Node[26];
		this.flag= false;
	}

	public boolean containsKey(char ch){
		return links[ch-'a'] != null;
	}

	public void put(char ch, Node node){
		links[ch-'a'] = node;
	}

	public Node get(char ch){
		return links[ch-'a'];
	}

	public void setEnd(char ch){
		flag=false;
	}






}