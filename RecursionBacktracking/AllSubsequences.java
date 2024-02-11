import java.util.ArrayList;
import java.util.List;
public class AllSubsequences{
	public static void main(String[] args){
		List<String> store= new ArrayList<>();
		String input = "abc";
		String temp = "";
		generate(0,input, temp, store );
		
		for(String str: store){
			System.out.print(str+ ", ");
		}
	}

	public static void generate(int ind, String s, String temp, List<String> store){
		if(ind==s.length()){
			store.add(temp);
			return;
		}
		generate(ind+1, s, temp+s.charAt(ind), store);
		generate(ind+1, s, temp, store);
	}
}