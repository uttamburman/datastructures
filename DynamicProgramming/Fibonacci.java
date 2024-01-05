import java.io.*;
import java.util.*;
import java.lang.*;
public class Fibonacci{
    public static void main(String[] args){
        Fibonacci fib=new Fibonacci();
        System.out.println("Enter number :");
        Scanner sc=new Scanner(System.in);
        int input=sc.nextInt();


        int ans = fib.solve(input);
        System.out.println(ans + " ");

        int[] dp=new int[input+1];
        int memAns= fib.solveMem(input, dp);
        System.out.println(memAns);

        int tabAns = fib.solveTab(input);
        System.out.println(tabAns);

        int soAns = fib.solveSO(input);
        System.out.println(soAns);
    }

    // S : O(1) , T : O(n^2)
    public int solve(int i){
        if(i==0) return 0;
        if(i<=2) return 1;
        return solve(i-1) + solve(i-2);
    }

    // S : O(n) , T : O(n) , Since none of the calls are repeating and hence there is a linear pattern
    public int solveMem(int i, int[] dp){
        if(i==0) return 0;
        if(i<=2) return 1;
        if(dp[i]!=0) return dp[i];
        return dp[i] = solve(i-1) + solve(i-2);
    }

    // S: O(n) , T: O(n) // Iterative Solution
    public int solveTab(int i){
        int[] dp=new int[i+1];
        dp[0]=0;
        dp[1]=1;
        for(int k=2;k<=i;k++){
            dp[k] = dp[k-1] + dp[k-2];
        }
        return dp[i];
    }

    //S : O(1) , T= O(n) // Space Optimized solution
    public int solveSO(int i){
        int prev2=0;
        int prev1=1;
        for(int k=2;k<=i;k++){
            int cur = prev1 + prev2;
            prev2=prev1;
            prev1=cur;
        }
        return prev1;
    }
}