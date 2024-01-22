import java.util.Queue;
import java.util.LinkedList;
public class RottenOranges{
	public static void main(String[] args){
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		RottenOranges rotUtil = new RottenOranges();
		rotUtil.rottenOranges(grid);
	}

	public int rottenOranges(int[][] grid){
		int row=grid.length;
		int col=grid[0].length;
		int totalOranges = 0;
		int freshOranges = 0;
		Queue<int[]> queue = new LinkedList<>();
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(grid[i][j] != 0) totalOranges++;
				if(grid[i][j] == 2) queue.offer(new int[]{i,j});
			}
		}

		int[] dx={0,0,1,-1};
		int[] dy={1,-1,0,0};
		int rottedOranges=0;
		int days=0;
		while(!queue.isEmpty()){

			int sz= queue.size();
			rottedOranges+=sz;
			for(int i=0;i<sz;i++){
				int[] pos = queue.poll();
				//Explore 4-directions
				for(int j=0;j<4;j++){
					int x= pos[0] + dx[j];
					int y= pos[1] + dy[j];

					if(x<0 || y<0 || x>=row || y >=col || grid[x][y] == 0 || grid[x][y] == 2) continue; 
					grid[x][y]=2;
					queue.offer(new int[]{x,y});
				}
			}
			//on last day , queue should get empty
			if(queue.size()!=0){
				days++;
			}
		}

		return totalOranges == rottedOranges ? days : -1;
	}
}
