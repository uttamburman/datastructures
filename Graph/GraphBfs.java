import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class GraphBfs{
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

		List<Integer> nodes= bfs(adj, N);

		for(Integer it: nodes){
			System.out.print(it + " ");
		}
	}

	public static List<Integer> bfs(ArrayList<ArrayList<Integer>> adj , int N){
		List<Integer> result= new ArrayList<>();
		boolean vis[]= new boolean[N+1];
		//Arrays.fill(vis, false);
		for(int i=1;i<N;i++){
			//if(adj.get(i).size()==0) continue;
			if(!vis[i]){
				bfsUtil(i, adj, N, result, vis);
			}
		}

		return result;
	}

	public static void bfsUtil(int node, ArrayList<ArrayList<Integer>> adj , int N, List<Integer> result,boolean vis[]){
		Queue<Integer> queue=new LinkedList<>();
		queue.offer(node);
		vis[node]=true;
		while(!queue.isEmpty()){
			int curNode= queue.poll();
			result.add(curNode);
			for(Integer neighbour: adj.get(curNode)){
				if(!vis[neighbour]){
					queue.offer(neighbour);
					vis[neighbour] = true;
				}
			}
		}
	}
}