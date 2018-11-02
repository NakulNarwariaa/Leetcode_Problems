import java.util.Stack;

public class SumSubArrayMins {
/* PROBLEM DESCRIPTION :
Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.

Since the answer may be large, return the answer modulo 10^9 + 7.

 

Example 1:

Input: [3,1,2,4]
Output: 17
Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 */
	
	public int sumSubarrayMins(int[] A) {
	    
		
        int[] left = new int[A.length];
        int[] right= new int[A.length];
        
        Stack<Integer> leftStack = new Stack<Integer>();
        Stack<Integer> rightStack = new Stack<Integer>();
        
        for(int i=0;i<A.length;i++){
            while(!leftStack.isEmpty() && A[leftStack.peek()]>A[i])
                leftStack.pop();  
               
            left[i] = leftStack.isEmpty()? i+1 : i-leftStack.peek();
            leftStack.push(i);
            
            
        }
        for(int i=A.length-1;i>=0;i--){
            while(!rightStack.isEmpty() && A[rightStack.peek()]>=A[i])
                rightStack.pop();
            
            right[i] = rightStack.isEmpty()? A.length-i :rightStack.peek() - i;
            rightStack.push(i);
        }
        
        int out =0;
        for(int i=0;i<A.length;i++)
            out = (out + left[i]*right[i]*A[i])%1000000007;
        
        return out;
        
    }
}
