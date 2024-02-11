import java.util.Map;
import java.util.HashMap;
public class RansomNote {
    public static void main(String[] args){
        String ransomNote = "aa";
        String magazine = "aab";
        boolean res = canConstruct(ransomNote, magazine);
        System.out.println(res);
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        
        int k= magazine.length();
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<k;i++){
            Character ch= magazine.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch, 1);
            }
            
            System.out.println(map.get(ch));
        }
        
        int l = ransomNote.length();
        for(int i=0;i<l;i++){
            Character ch= ransomNote.charAt(i);
            if(map.containsKey(ch)){
                map.computeIfPresent(ch, (key, val)-> val-1);
                System.out.println(map.get(ch));
                if(map.get(ch)<0) return false;
            }else return false;
        }
        return true;
    }
}