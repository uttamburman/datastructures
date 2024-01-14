import java.util.Arrays;
public class GridPath{
	/**
	 * Find All Paths from 0,0 to n,n
	 * we can move in left, right down
	 **/
	public static void main(String[] args){
		int[][] grid=new int[4][4];
		GridPath allPaths=new GridPath();

		int[][] dp= new int[grid.length][grid[0].length];
		for (int[] row : dp)
            Arrays.fill(row, -1);
		int paths=allPaths.findPaths(grid.length-1,grid[0].length-1, dp);
		int pathsTab=allPaths.findPathsTab(grid.length,grid[0].length);
		System.out.println(paths);
		System.out.println(pathsTab);
	}

	public int findPaths( int i, int j, int dp[][]){
		if( i == 0 && j == 0){
			return 1;
		}

		if( i < 0 || j < 0){
			return 0;
		}
		if(dp[i][j] != -1) return dp[i][j];
		return dp[i][j] = findPaths(i-1,j, dp) + findPaths(i,j-1,dp);
	}

	public int findPathsTab( int i, int j){
		int dp[][] = new int[i][j];
		
		for(int k=0;k<i;k++){
			for(int l=0;l<j;l++){
				if(k==0 && l==0){
					dp[k][l]=1;
					continue;
				}
				int down=0;
				int right=0;
				if(k > 0){
					down = dp[k-1][l];
				} 
				if(l > 0){
					right = dp[k][l-1];
				}
				dp[k][l] = down + right;
			}
		}
		return dp[i-1][j-1];
	}

	public int findPathsSo(int m, int n){
		
	}
}