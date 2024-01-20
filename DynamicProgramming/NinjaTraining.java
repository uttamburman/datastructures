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
	public int doTrainingTab(int[][] points ){
		int n=points.length;
		int m=points[0].length;
		int[][] dp = new int[n][m+1];

		dp[0][0] = Math.max(points[0][1], points[0][2]);
		dp[0][1] = Math.max(points[0][0], points[0][2]);
		dp[0][2] = Math.max(points[0][0], points[0][1]);
		dp[0][3] = Math.max(points[0][0], Math.max(points[0][2], points[0][1]));

		//0th day is initialized, so we start from day 1
		//One thing to note here is last can be either of the 3 for each day 
		for(int day=1;day < n; day++){
			//One thing to note here is last can be either of the 3 for each day and since we started
			//Again, since we do not know what will be there on 1st day , we take and extra case for that
			for(int last = 0; last < 4; last++){
				dp[day][last]=0;
				for(int task=0; task< m; task++){
				if(task != last){
						int activity= points[day][task] + dp[day-1][task];
						dp[day][last] =  Math.max(activity,dp[day][last]);
					}
				}
			}
			
		}
		
		

		return dp[n-1][m];
	}
}