public class SearchRotatedSortedArray{
	public static void main(String[] args){
		int[] arr= {4,6,7,8,9,1,2,3};
		int target =6;

		int index= findElement(arr, target);
		System.out.println(index+" ");
	}

	public static int findElement(int[] nums, int target){
		int low=0;
		int high=nums.length-1;
		int mid;

		while(low<=high){
			mid=(low+high)/2;
			if(nums[mid]==target) return mid;
			if(nums[low]<=nums[mid]){
				if(nums[low]<=target && nums[mid]>=target){
					high=mid-1;
				}else{
					low=mid+1;
				}
			}else{
				if(nums[mid]<=target && nums[high]>=target){
					low=mid+1;
				}else{
					high=mid-1;
				}
			}
		}
		return -1;
	}
}