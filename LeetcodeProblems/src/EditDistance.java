/*
 * 
 * 72. Edit Distance
 * 
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 */
public class EditDistance {
	
	public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();
        
        if(m == 0)
            return n; 
        if(n== 0)
            return m;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i= 0; i<=n ; i++)
            dp[0][i] = i;
        
        for(int i=0;i<=m;i++)
            dp[i][0] = i;
        
        for(int i=1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                
            	//case when ith and jth character are equal and where word1.substring(0,i) is already equal to word2.substring(0,j)
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
            
                // case when ith char != jth char. Three possibilities - 
                dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), dp[i-1][j-1]+1);
                // 1. Insertion - dp[i-1][j] + 1 where ith char is being inserted to make word1.substring(0,i) = word2.substring(0,j)
                // 2. Deletion - dp[i][j-1] + 1 where ith char is being deleted
                // 3. Replacement - dp[i-1][j-1] +1 where ith/jth char is being replaced.
            
            }
        }
        
        return dp[m][n];
        
    }

}
