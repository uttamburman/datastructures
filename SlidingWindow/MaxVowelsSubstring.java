class MaxVowelsSubstring {
    public static void main(String[] args){
        String s = "abciiidef";
        int k = 3;
        int count=maxVowels(s,k);
        System.out.println(count+ " ");

    }
    public static int maxVowels(String s, int k) {
        int j = 0, curCount = 0, max = 0;
        int[] map= new int[26];
        map['a'-'a']++;
        map['e'-'a']++;
        map['i'-'a']++;
        map['o'-'a']++;
        map['u'-'a']++; 
        
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            curCount+= map[c-'a']!=0 ? 1 : 0;
            if(i >= k-1){
                max= Math.max(max, curCount);
                if(map[s.charAt(j++)-'a'] !=0) curCount--;
            }
        }
        
        return max;
    }
}