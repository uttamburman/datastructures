import java.util.List;
import java.util.ArrayList;

//Sums of all subsets
public class SubsetSum{
	public static void main(String[] args){
		int[] arr= {3,5,2,7,9,4,1,6,8};
		List<Integer> ans = findSubsets(arr);
	}

	public static List<Integer> findSubsets(int[] nums){
		int n=nums.length-1;
		List<Integer> subset = new ArrayList<>();

		subsetTargetUtil(n, nums, 0, subset);
		return subset;
	}

	public static void subsetTargetUtil(int ind, int[] nums, int sum, List<Integer> subset){
		if(ind==0){
			subset.add(sum);
			return;
		}
		subsetTargetUtil(ind-1, nums, sum+nums[ind], subset);
		subsetTargetUtil(ind-1, nums, sum, subset);

		
	}
}