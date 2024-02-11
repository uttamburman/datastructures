import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing{
	public static void main(String[] args){

	}

	public int[] sequenceJobsForMaxProfit(Job[] jobs, int n){
		Arrays.sort(jobs, (a,b)-> (b.profit - a.profit));
		int countJobs = 0;
		int jobProfit = 0;

		//Find Max Deadline - Days or Hour whatever
		int maxDeadline=0;
		for(int i=0;i<n;i++){
			maxDeadline= Math.max(maxDeadline, jobs[i].deadline);
		}

		//Create a placeholder to hold tasks to be done on each unit Day or Hour
		int result[] = new int[maxDeadline+1];
		Arrays.fill(result,-1);

		// Since we have already sorted jobs based on profit 
		// and to greedily do those jobs, we want to get maximum profit by end, 
		// So we start with maximum profit job and place it to the max deadline it can have 
		// If position is filled we try to complete it earlier
		// If all positions are filled, that's the max profit we can make
		for(int i=0;i<n;i++){

			for(int j=jobs[i].deadline;j>=0;j--){
				//check if position is already filled
				if(result[j]==-1){
					result[j]=i;
					countJobs++;
					jobProfit+=jobs[i].profit;
					break;
				}
			}
		}

		int[] ans= new int[2];
		ans[0]=countJobs;
		ans[1]=jobProfit;
		return ans;
	}
}

class Job{
	int id, deadline, profit;

	public Job(int id, int deadline, int profit){
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
}