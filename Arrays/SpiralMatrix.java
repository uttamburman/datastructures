import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix{
	public static void main(String[] args){
		int[][] mat = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16}};
                       
        spiralOrder(mat);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans= new ArrayList<>();
        int top=0, bottom=matrix.length-1, left=0, right=matrix[0].length-1;
        
        while(top<=bottom && left<=right){
            
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            
            for(int i=top; i<=bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;
            
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if(left<=right){
                for(int i=bottom; i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return ans;
    }
}