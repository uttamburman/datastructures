public class SubsetSumTarget{
	public static void main(String[] args){
		int[] arr= {3,5,6,1,2};
		int target=7;
		SubsetSumTarget subsetSum=new SubsetSumTarget();
		int ways = subsetSum.findWays(arr, target);
		System.out.println(ways+" ");
	}

	public int findWays(int[] arr, int target){
		int n=arr.length;
		return findWaysUtil(n-1, arr, target);
	}

	public int findWaysUtil(int ind, int[] arr, int target){
		if(target==0) return 1;
		if(ind==0){
			if(target==arr[ind]) return 1;
			else return 0;
		}
		int take= 0;
		if(arr[ind]<=target){
			take=findWaysUtil(ind-1, arr, target-arr[ind]);
		}

		int notTake = findWaysUtil(ind-1, arr, target);
		
		return take+notTake;
	}
}