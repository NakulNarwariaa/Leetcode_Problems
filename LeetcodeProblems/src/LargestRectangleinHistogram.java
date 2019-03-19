/*
 * 84. Largest Rectangle in Histogram
 * 
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 */



import java.util.Stack;

public class LargestRectangleinHistogram {
	
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
