/*
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 */
public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
        
        int[] q = new int[nums.length];
        int overAllMax= 0;
        for(int i=nums.length-1;i>=0;i--){
            
            int max = 0;
            for(int j=nums.length-1;j>i;j--){
                if(max< q[j] && nums[i]<nums[j] )
                    max = q[j];
           
            }
            q[i] = 1 + max;
            overAllMax = overAllMax<q[i]?q[i]:overAllMax;
        }
        return overAllMax;    
    }
}
