public class NinjaTraining{
	public static void main(String[] args){
		int[][] trainingPoints = {{3,6,8},{12,11,17},{98,37,67}};
		NinjaTraining train = new NinjaTraining();
		int maxPoints = train.getMaxPoints(trainingPoints);
		System.out.println(maxPoints+" ");
	}

	public int getMaxPoints(int[][] trainingPoints){
		int n=trainingPoints.length;
		int m= trainingPoints[0].length;
		// send anything out of bounds in last activity , because we haven't done any
		//return doTraining(n-1, m, trainingPoints); 
		int[][] dp= new int[n][m+1]; //m+1 as we're sending out of bounds activity on first day
		return doTrainingMem(n-1, m, trainingPoints, dp); 
	}

	public int doTraining(int day, int last_act, int[][] points ){
		if(day ==0 ){
			int maxi = 0;
			for(int i=0;i <points[0].length ;i++){
				maxi=Math.max(points[0][i], maxi);
			}
			return maxi;
		}

		int maxi=0;
		for(int i=0; i< points[0].length; i++){
			if(i != last_act){
				maxi =  Math.max(points[day][i] + doTraining(day-1 , i, points),maxi);
			}
		}

		return maxi;
	}

	public int doTrainingMem(int day, int last_act, int[][] points, int[][] dp ){
		if(dp[day][last_act] != 0 ) return dp[day][last_act];
		if(day ==0 ){
			int maxi = 0;
			for(int i=0;i <points[0].length ;i++){
				maxi=Math.max(points[0][i], maxi);
			}
			return dp[day][last_act] = maxi;
		}

		int maxi=0;
		for(int i=0; i< points[0].length; i++){
			if(i != last_act){
				maxi =  Math.max(points[day][i] + doTrainingMem(day-1 , i, points, dp),maxi);
			}
		}

		return dp[day][last_act] =  maxi;
	}

	//TODO : complete program
	public int doTrainingTab(int day, int last_act, int[][] points, int[][] dp ){
		if(dp[day][last_act] != 0 ) return dp[day][last_act];
		if(day ==0 ){
			int maxi = 0;
			for(int i=0;i <points[0].length ;i++){
				maxi=Math.max(points[0][i], maxi);
			}
			return dp[day][last_act] = maxi;
		}

		int maxi=0;
		for(int i=0; i< points[0].length; i++){
			if(i != last_act){
				maxi =  Math.max(points[day][i] + doTrainingMem(day-1 , i, points, dp),maxi);
			}
		}

		return dp[day][last_act] =  maxi;
	}
}