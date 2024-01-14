public class LongestIncreasingSubsequence{
	public static void main(String[] args){
		int[] arr={8,5,6,9,2,4,78,9,2,1,6,7,5,11,89,58};

		int length = largestIncreasingSubsequence(arr);
		System.out.println(length);

	}

	public static int largestIncreasingSubsequence(int[] arr){
		int[][] dp=new int[arr.length][arr.length+1];
		return findLisMem(0, -1, arr,dp);
		//return findLis(0, -1, arr);

	}

	private static int findLis(int ind, int prev_ind, int[] arr){
		if(ind==arr.length) return 0;

		int notTake = 0 + findLis(ind + 1, prev_ind, arr);

		int take = 0;
		if(prev_ind == -1 || arr[ind] > arr[prev_ind]){
			take = 1+ findLis(ind+1 , ind, arr);
		} 
		return Math.max(take,notTake);
	}

	private static int findLisMem(int ind,int prev_ind, int[] arr, int[][] dp){
		if(ind==arr.length) return 0;

		if(dp[ind][prev_ind] !=0 ) return dp[ind][prev_ind];
		int notTake = 0 + findLisMem(ind + 1, prev_ind, arr, dp);

		int take = 0;
		if(prev_ind == -1 || arr[ind] > arr[prev_ind]){
			take = 1+ findLisMem(ind+1 , ind, arr, dp);
		} 
		return dp[ind][prev_ind]=Math.max(take,notTake);
	}

	private static int findLisTab(int ind,int prev_ind, int[] arr){
		int[][] dp=new int[arr.length][arr.length+1];
		if(ind==arr.length) return 0;

		
		int notTake = 0 + findLis(ind + 1, prev_ind, arr);

		int take = 0;
		if(prev_ind == -1 || arr[ind] > arr[prev_ind]){
			take = 1+ findLis(ind+1 , ind, arr);
		} 
		return Math.max(take,notTake);
	}
}