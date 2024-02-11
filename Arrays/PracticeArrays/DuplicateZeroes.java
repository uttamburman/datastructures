public class DuplicateZeroes{
	public static void main(String[] args){

	/*	Input: arr = [1,0,2,3,0,4,5,0]
		Output: [1,0,0,2,3,0,0,4]
	*/

		int[] arr= {1,0,2,3,0,4,5,0};

		duplicateZeros(arr);


	}

	public static void duplicateZeros(int[] arr) {

		for(int i=0;i<arr.length;i++){
			if(arr[i]==0 && i!=arr.length-1){
				for(int j=arr.length-1;j>=i+1;j--){
					arr[j]=arr[j-1];
				}
				arr[i+1]=0;
				i++;
			}	
		}

		for(int a : arr){
			System.out.print(a+", ");
		}
	}
}