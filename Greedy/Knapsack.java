/**
 * This is slightly different from 0/1 Knapsack and Unbounded Knapsack.
 * 0/1 knapsack does not talks about picking unit of a particular item
 * Unbounded knapsack is an extension of 0/1 knapsack with unlimited supply of each item.
 * This is slightly different by the fact that unit we can divide item's value and weight to get profit of each unit weight.
 */
import java.util.Comparator;
import java.util.Arrays;

public class Knapsack{
	public static void main(String[] args){
		
	}

	public static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new ItemComparator()); 
        
        int curWeight = 0; 
        double finalvalue = 0.0; 
        
        for (int i = 0; i < n; i++) {
       
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            }
     
            else {
                int remain = W - curWeight;
                finalvalue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
                break;
            }
        }
     
        return finalvalue;
        
    }
}

class ItemComparator implements Comparator<Item>{

	@Override
	public int compare(Item a, Item b){
		double r1= (double) a.value/ (double) a.weight;
		double r2= (double) b.value/ (double) b.weight;

		if(r1<r2) return 1;
		else if(r1>r2) return -1;
		else return 0;
	}	
}

class Item{
	int weight, value;

	public Item(int value, int weight){
		this.value=value;
		this.weight=weight;
	}
}