public class CherryPickup{
	public static void main(String[] args){
		int[][] grid={{2, 3, 1, 2},
                      {3, 4, 2, 2},
                      {5, 6, 3, 5}};
        CherryPickup pickup = new CherryPickup();
        int ans = pickup.maxChocolates(grid);
        System.out.println(ans+" ");
	}

	public int maxChocolates(int[][] grid){
		int n=grid.length;
		int m=grid[0].length;
		return maxChocoUtil(0,0,m-1,n,m, grid);
	}

	public int maxChocoUtil(int i, int j1, int j2,int n, int m, int[][] grid){
		if(j1 >= n || j1 < 0 || j2 >= n || j2 < 0){
			return (int)(Math.pow(-10,9));
		}
		if(i==n-1){
			if(j1==j2) return grid[i][j1];
			else return grid[i][j1] + grid[i][j2];
		}

		int maxi=Integer.MIN_VALUE;
		for(int di=-1;di <=1; di++){
			for(int dj=-1; dj<=1;dj++){
				int ans=0;
				if(j1==j2) ans = grid[i][j1] + maxChocoUtil(i+1, j1+di, j2+dj,n, m, grid );
				else ans = grid[i][j1] + grid[i][j2] + maxChocoUtil(i+1, j1+di, j2+dj,n, m, grid );
				maxi= Math.max( maxi, ans);
			}
		}

		return maxi;
	}
}