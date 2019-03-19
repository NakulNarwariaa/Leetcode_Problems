/*
 * 85. Maximal Rectangle
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 */

import java.util.Stack;

public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {
        
        
        if(matrix.length <= 0)
            return 0;
        if( matrix[0].length <=0)
            return 0;
        
        int m = matrix.length;
        int n= matrix[0].length;
        
        int[] dp = new int[n];
        int max = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0')
                    dp[j] = 0;
                else
                    dp[j] = i>0? dp[j]+1 : 1;
            }
            max = Math.max(max,largestRectangleArea(dp) );
        }
     
        return max;
    }
    
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        
        if(n==0 || heights==null)   
            return 0;
        
        int max = 0;
        Stack<Integer> bars = new Stack<>();
        int i=0;
        for(i = 0;i<n;i++){
            if(bars.isEmpty() || i==0 || heights[bars.peek()] <= heights[i]){
                bars.push(i);
                continue;
            }
            
            while(!bars.isEmpty() && heights[bars.peek()] > heights[i] ){
                int minHeightIndex = bars.pop();
                int leftIndex = bars.isEmpty() ? -1 : bars.peek();
                int rightIndex = i;
                int newArea = (rightIndex - leftIndex -1) * heights[minHeightIndex];
                max = max< newArea ? newArea : max;
                
            }
            bars.push(i);
        }
        
        while(!bars.isEmpty()){
            int minHeightIndex = bars.pop();
            int leftIndex = bars.isEmpty() ? -1: bars.peek();
            int rightIndex = i;
            int newArea = (rightIndex - leftIndex -1) * heights[minHeightIndex];
            max = max< newArea ? newArea : max;
        }
        
        return max;
        
    }
}
