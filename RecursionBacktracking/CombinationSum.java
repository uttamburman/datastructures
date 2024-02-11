import java.util.List;
import java.util.ArrayList;

public class CombinationSum{
	public static void main(String[] args){
		int[] arr ={2,3,6,7};
		int target = 7;
	}

	private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> store) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList < > (store));
            }
            return;
        }

        if (arr[ind] <= target) {
            store.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, store);
            store.remove(store.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, store);
    }

}