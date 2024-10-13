public class CoinDenomination{
	public static void main(String[] args){
		int[] coins = {1,2,5};
		int target = 113;

		int ans = findDenominations(coins, target);
	}

	public static int findDenominations(int[] coins, int target){
		return coinUtil(coins.length-1,coins, target);
	}

	public static int coinUtil(int ind, int[] coins, int target){
		if(ind == 0) {
			if(target%coins[ind] == 0) return target/coins[ind];
			else return (int)1e9;
		}

		int take = 0;
		if(target > coins[ind]){
			take = 1+ coinUtil(ind-1, coins, target-coins[ind]);
		}
		int notTake = coinUtil(ind-1, coins, target);

		return Math.min(take, notTake);
	}
}