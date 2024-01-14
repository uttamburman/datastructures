import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class GroupAnagrams{
	public static void main(String[] args){
		String[] words = {"eat","tea","tan","ate","nat","bat"};
		GroupAnagrams groupAnagrams = new GroupAnagrams();

		List<List<String>> result = groupAnagrams.group(words);
		for(List<String> wordGroup : result){
			for(String word : wordGroup){
				System.out.print(word + ", ");
			}
			System.out.println();
		}
	}

	public List<List<String>> group(String[] words){
		Map<Map<Character, Integer>, ArrayList<String>> map =  new HashMap<>();
		List<List<String>> result = new ArrayList<>();
		for(String str : words){
			Map<Character, Integer> freqMap = new HashMap<>();
			for(int i=0;i<str.length();i++){
				char ch = str.charAt(i);
				freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
			}

			if(!map.containsKey(freqMap)){
				ArrayList<String> wordList=new ArrayList<>();
				wordList.add(str);
				map.put(freqMap,wordList);
			}else{
				map.get(freqMap).add(str);
			}
		}

		for(ArrayList<String> list: map.values()){
			result.add(list);
		}

		return result;
	}


}