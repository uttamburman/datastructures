public class QuickSort{
	public static void main(String[] args){
		int[] arr= {6,2,8,3,1,9,4,5};
		QuickSort util= new QuickSort();
		util.quickSort(arr);
	}

	public void quickSort(int[] arr){
		int low= 0;
		int high= arr.length-1;
		qs(low, high, arr);
		for(int k: arr){
			System.out.print(k+", ");
		}
		
	}

	public void qs(int low,int high,int[] arr){
		if(low < high){
			int pivotIndex = partition(low, high, arr);
			qs(low,pivotIndex-1, arr);
			qs(pivotIndex+1,high, arr);
		}
	}

	public int partition(int low, int high, int[] arr){
		int i= low;
		int j= high;
		int pivot= arr[low];
		while(i<j){
			while(arr[i]<=pivot && i<=high-1){
				i++;
			}

			while(arr[j]>pivot && j>= low+1){
				j--;
			}

			if(i<j){
				int temp= arr[i];
				arr[i]=arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[low];
		arr[low] = arr[j];
		arr[j] = temp;

		return j;
	}
}