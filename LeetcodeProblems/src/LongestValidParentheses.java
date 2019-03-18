/*
 * 32. Longest Valid Parentheses
 * 
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 */
public class LongestValidParentheses {
	
	public int longestValidParentheses(String s) {
        int n = s.length();
        
        if(n <= 1)
            return 0;
        
        int[] dp = new int[n]; // dp[i] = length of largest valid string ending at i
        int max = 0;
        
        for(int i=0;i<n;i++){

            //No valid string ends at (
            if(s.charAt(i)=='(')
                continue;
            
            // last 2 chars are valid string + whatever the largest valid string ending just before last 2 chars.
            if(i-1>= 0 && s.charAt(i-1)=='(')
                dp[i] = i-2 >= 0 ? dp[i-2]+2 : 2; 
            
            // if last second char is ) too then dp[i] = valid string ending on (i-1)th position + 2[ enclosing () at x and i]
            // + valid largest string just  before the enclosing string. eg = ()(())
                  
            else if(i >0 && i-dp[i-1] -1 >=0 && s.charAt(i-dp[i-1]-1) == '(')
                dp[i] = i-dp[i-1]-2 >= 0 ? dp[i-1] +2 + dp[i-dp[i-1]-2] : dp[i-1] +2; 
            
            max = max < dp[i] ? dp[i] : max;
            
        }
        
        return max;
        
    }

}
