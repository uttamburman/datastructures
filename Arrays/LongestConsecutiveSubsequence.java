import java.util.Set;
import java.util.HashSet;
public class LongestConsecutiveSubsequence{
	public static void main(String[] args){
		int[] arr = {100, 200, 1, 2, 3, 4};

		int ans= longestConsecutiveArray(arr);
	}

	public static int longestConsecutiveArray(int[] a){
		int n = a.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        for (int it : set) {
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;


	}
}

/**Time Complexity is N, Why? (N + 2*N = ~3N = N)
* Since we start with some element and search for consecutively increasing numbers
* if many are there with increasing we keep counting and adding
* if all are there it's only one loop , so 2 loops in total
* In case of hits and misses only the time complexity will increase to N^2
* 
* 
* */

