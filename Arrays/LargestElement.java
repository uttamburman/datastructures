public class LargestElement{
	public static void main(String[] args){
		int[] arr={8,5,6,9,2,4,78,9,2,1,6,7,5,11,89,58};
		LargestElement largestElement = new LargestElement();
		int element = largestElement.getLargestElement(arr);
		System.out.println(element + "");
	}

	public int getLargestElement(int[] arr){
		int max= arr[0];

		for(int i = 0;i < arr.length; i++){
			max=Math.max(arr[i],max);
		}
		return max;
	}
}