public class MaximumSumNonAdjacent{
	public static void main(String[] args){
		int[] arr = {2,1,4,9};
		MaximumSumNonAdjacent maxSum = new MaximumSumNonAdjacent();
		int ans = maxSum.findSum(arr.length-1,arr);
		System.out.println(ans);
	}

	public int findSum(int ind, int[] arr){
		if(ind == 0) return arr[ind];
		if(ind < 0) return 0;
		int take=arr[ind] + findSum(ind-2, arr);
		int notTake= 0 + findSum(ind-1, arr);
		return Math.max(take,notTake);
	}
}