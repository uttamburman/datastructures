public class SortedArrayMinimumAbsoluteDifferenceTarget{
	public static void main(String[] args){
		int[] arr1= {1, 4, 5, 7}; 
		int[] arr2 = {10, 20, 30, 40};
		int x=32;

		//arr1[i] + arr2[j] – x
		findMinimumDifference(arr1, arr2, x);
	}

	public static int[] findMinimumDifference(int[] arr1, int[] arr2, int x){
		int min= Integer.MAX_VALUE;
		int iMin=0;
		int jMin=0;
		int n= arr1.length;

		for(int i=0;i<n;i++){
			int diff= Math.abs(arr[i]-x);
			int upperBoundInd= Arrays.binarySearch(arr[j], diff);

			
		}
	}



}