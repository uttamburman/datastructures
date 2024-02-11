public class Sort0s1s2sDutchNationalFlag{
	public static void main(String[] args){
		int[] a = {1,1,0,0,2,2,1,2,0};

		sort(a);
		for(int it : a){
			System.out.print(it+" ");
		} 
	}

	public static void sort(int[] a){
		int low =0;
		int mid=0;
		int high= a.length-1;


		while(mid<=high){
			switch(a[mid]){
			case 0:
				swap(a,low, mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2: 
				swap(a, mid, high);
				high--;
				break;
			}
		}
	}

	private static void swap(int[] a, int i, int j){
		int temp= a[i];
		a[i]=a[j];
		a[j] = temp;
	}
}

