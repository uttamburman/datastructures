import java.util.ArrayList;
import java.util.List;
public class PhoneCombination{
	public static void main(String[] args){
		PhoneCombination phone = new PhoneCombination();
		phone.findCombinations("378");
	}

	public void findCombinations(String numInput){
		String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		List<String> ans=new ArrayList<>();
		combinationUtil(0,numInput,map,"", ans);
		for(String str: ans){
			System.out.print(str+", ");
		}
	}

	/**
	 * ind represents numString/input index 
	 **/
	public void combinationUtil(int ind, String numString, String[] map, String tempString, List<String> ans){
		if(ind == numString.length()){
			ans.add(tempString);
			return;
		}
		char ch = numString.charAt(ind);
		String letters = map[ch - '0'];
		for(char c: letters.toCharArray()){
			combinationUtil(ind+1, numString, map, tempString+c, ans);
		}
	}
}