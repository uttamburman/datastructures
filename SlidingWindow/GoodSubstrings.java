class GoodSubstrings {
    public static void main(String[] args){
        String s="xyzzaz";
        GoodSubstrings solution = new GoodSubstrings();
        solution.countGoodSubstrings(s);
    }
    public int countGoodSubstrings(String s) {
        int i=0,j=0,count=0;
        
        while(j<s.length()){
            if(j-i+1==3){
                if(s.charAt(i)!=s.charAt(i+1) && s.charAt(i)!=s.charAt(i+2) && s.charAt(i+1)!=s.charAt(i+2)){
                    count++;
                }
                i++;
            }
            j++;
        }
        return count;
    }
}