public class HouseRobberUnbounded {
    public static void main(String args[]) {
      //int[] arr= {4, 5, 9, 1, 2, 8, 6, 10 };
      int[] arr= {9,1,1,9 };
      maxSteal(arr);
    }
    
    public static void maxSteal(int[] arr){
        int n= arr.length-1;
        
        int maxSteal= stealUtil(n,arr);
        System.out.print(maxSteal+"");
       
    }
    
    private static int stealUtil(int ind, int[] arr){
        if(ind<=1) return arr[ind];
        if(ind<0) return 0;
        
        int maxPick=0;
        int pick = 0;         
        for(int i=2;i<arr.length-1;i+=2){
            if(ind>1){
                pick= arr[ind] + stealUtil(ind-i, arr);
            }
            maxPick= Math.max(maxPick, pick);
        }
        int notPick = 0 + stealUtil(ind-1, arr);
         
        
        return Math.max(maxPick, notPick);
    }
    
    
}