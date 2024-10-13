import java.util.Set;
import java.util.HashSet;

public class LongestSubstringNoRepeating{
	public static void main(String[] args){
		String s= "abcabcabb";
		lengthOfLongestSubstring(s);
	}


	public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left=0;
        Set<Character> set= new HashSet<>();
        for(int right=0;right<s.length();right++){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength = Math.max(right-left+1,maxLength);
            }else{
                while(s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
                set.add(s.charAt(right));
            }
        }
        return maxLength;
        
    }
}