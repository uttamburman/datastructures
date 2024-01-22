import java.util.ArrayList;
import java.util.List;
public class GraphDfs{
	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> adj= new ArrayList<>();

		int N= 8;
		for(int i=0;i<=N;i++){
			adj.add(new ArrayList<>());
		}

		adj.get(1).add(2);
		adj.get(1).add(6);

		adj.get(2).add(3);
		adj.get(2).add(1);
		adj.get(2).add(4);

		adj.get(3).add(2);

		adj.get(4).add(2);
		adj.get(4).add(5);

		adj.get(5).add(4);
		adj.get(5).add(7);

		adj.get(7).add(6);
		adj.get(7).add(5);

		adj.get(6).add(1);
		adj.get(6).add(7);
		adj.get(6).add(8);
		List<Integer> nodes = dfs(adj, N);
		for(Integer it: nodes){
			System.out.print(it + " ");
		}
	}

	public static List<Integer> dfs(ArrayList<ArrayList<Integer>> adj ,  int N){
		boolean[] vis= new boolean[N+1];
		List<Integer> result = new ArrayList<>();
		for(int i=0;i<=N;i++){
			if(!vis[i]){
				dfsUtil(i, adj, vis, result);
			}
		}

		return result;
	}

	public static void dfsUtil(Integer node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, List<Integer> result){
		vis[node] = true;
		result.add(node);
		for(Integer it : adj.get(node)){
			if(!vis[it]){
				dfsUtil(it,adj, vis, result );
			}
		}
	}
}