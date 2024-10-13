import java.util.*;
public class Permutation{
	public static void main(String[] args){
		int[] nums = {3,2,4,5};
		List<List<Integer>> ans = new ArrayList<>();
		permute(0, nums,ans);
		for(List<Integer> lst : ans){
			System.out.println(lst.toString());
		}
	}

	public static void permute(int ind, int[] nums, List<List<Integer>> ans){
		if(ind == nums.length){
			List<Integer> ds = new ArrayList<Integer>();
			for(int i : nums){
				ds.add(i);
			}
			ans.add(new ArrayList<>(ds));
		}

		for(int i=ind; i<nums.length ; i++){
			swap(i, ind, nums);
			permute(ind+1, nums, ans);
			swap(i,ind,nums);
		}
	}

	public static void swap(int i, int j, int[] nums){
		int temp = nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
}