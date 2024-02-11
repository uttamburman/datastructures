public class KnapsackUnbounded{
	public static void main(String[] args){
		int wt[] = {1, 2, 4, 5};
        int val[] = {5, 4, 8, 6};
        int W = 5;
        int n = wt.length;
        int max = knapsack(n-1,wt,val,W);
        System.out.println(max+" ");
	}

	public static int knapsack(int ind, int[] wt, int[] val, int W){
		if(ind==0) {
			if(wt[ind]<=W) return val[ind]* (W/wt[ind]);
			else return 0;
		}

		int take= 0;
		if(wt[ind]<=W){
			take = val[ind]+knapsack(ind-1, wt, val, W-wt[ind]);
		}
		int notTake= 0+knapsack(ind-1, wt, val, W);
		
		return Math.max(take, notTake);
	}
}

//TODO: NOT CORRECT