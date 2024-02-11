import java.util.Scanner;
public class FindArithmeticSequence{
  public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    String line = sc.nextLine();
    String[] numStrs= line.split(" ");
    int[] nums= new int[3];
    int i=0;
    
    for(String str: numStrs){
      nums[i]=Integer.parseInt(str);
      i++;
    }
    findSequence(nums);
  }
  
  public static void findSequence(int[] nums){
    int a= nums[0];
    int b= nums[1];
    int d= nums[2];
    
    for(int i=a;i<=b;i+=d){
      System.out.print(i+" ");
    }
  }
}