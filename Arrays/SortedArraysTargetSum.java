public class SortedArraysTargetSum{
	public static void main(String[] args){
		int[] arr1= {2,4,6,8,10};
		int[] arr2= {1,3,6,7,9};

		int target= 14;

		int[] ans = findPair(arr1,arr2, target);
		System.out.println(ans[0] + ", " + ans[1]);
	}

	public static int[] findPair(int[] arr1, int[] arr2, int target){
		int j=0, i=arr1.length-1;

		while(i>=0){
			if(j>=arr2.length) return new int[]{-1,-1}; 
			if(arr1[i]+arr2[j] == target) return new int[]{arr1[i],arr2[j]};
			else if(arr1[i]+arr2[j] > target) i--;
			else j++;
		} 

		return new int[]{-1,-1};
	}
}