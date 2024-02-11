import java.util.HashMap;
public class TwoSum{
	public static void main(String[] args){
		int[] arr= {2,3,6,8,1,9,4};
		int target= 10;
		int[] ans = findElements(arr, target);
		for(int i: ans){
			System.out.print(i+" ");
		}
	}

	public static int[] findElements(int[] nums, int target){
		HashMap<Integer, Integer> map=new HashMap<>();

		for(int i=0;i<nums.length;i++){
			if(map.containsKey(target-nums[i])) return new int[]{map.get(target-nums[i]),i };
			map.put(nums[i],i);
		}
		return new int[]{};
	}
}