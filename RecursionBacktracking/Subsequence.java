public class Subsequence{
    public static void main(String[] args){
        String s1="abcde";
        String s2="ace";

        Subsequence solve = new Subsequence();
        int ans = solve.longestSubsequence(s1,s2);
        System.out.println(ans);
    }

    public int longestSubsequence(String s1, String s2){
        return processSubsequence(s1,s2,0,0);
    }

    private int processSubsequence(String s1 , String s2, int i, int j){
        if(i == s1.length() || j == s2.length()) return 0;

        if(s1.charAt(i) == s2.charAt(j)) return 1 + processSubsequence(s1,s2, i+1, j+1);
        else return Math.max(processSubsequence(s1,s2, i, j+1) , processSubsequence(s1,s2, i+1, j));
    }
}