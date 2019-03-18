/*
 * 5. Longest Palindromic Substring
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 */



public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
        int n = s.length();

        if(n<=1)
            return s;
        
        boolean[][] dp = new boolean[n][n];
        String out = "";
        
        for(int i = n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j)
                    dp[i][j] = true;
                else if(j-i == 1 && s.charAt(i)==s.charAt(j))
                    dp[i][j]=true;
                else if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1])
                    dp[i][j] = true;
                
                if(dp[i][j] && out.length() < j-i+1)
                    out = s.substring(i,j+1);
                
            }
        }
        return out;
        
    }
}
