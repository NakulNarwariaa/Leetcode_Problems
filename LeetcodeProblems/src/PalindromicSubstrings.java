/*
 * 647. Palindromic Substrings
 * 
 * Given a string, your task is to count how many palindromic substrings in this string.
 * 
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 */


public class PalindromicSubstrings {

 	public int countSubstrings(String s) {
        
        int n = s.length();
        if(s == null || n <1)
            return 0;
        if(n==1)
            return 1;
        
        boolean[][] dp = new boolean[n][n];
        int count =0 ;
        
        for(int start = n-1; start >=0 ; start--)
        {
            for(int end = start;end<n;end++){
                if(start==end){
                    count++;
                    dp[start][end] = true;
                    continue;
                }
                if(end-start == 1){
                    if(s.charAt(end)==s.charAt(start)){
                        count++;
                        dp[start][end] = true;
                    }
                    continue;
                }
                if(s.charAt(start)!=s.charAt(end))
                    continue;
                if(dp[start+1][end-1]){
                    count++;
                    dp[start][end] = true;
                    continue;
                }
            }
        }
        
        return count;
    //    return alternateSolution(s);
        
    }
    
    public int alternateSolution(String s){
        int n = s.length();
        if(s == null || n <1)
            return 0;
        if(n==1)
            return 1;
        
        int count =0;
        //for odd
        for(int i=0;i<n;i++){
            int start =i;
            int end = i;
            while(start>=0 && end<n && s.charAt(start)==s.charAt(end)){
                start--;
                end++;
                count++;
            }
        }
        
        //for even
        for(int i=0;i<n-1;i++){
            int start =i;
            int end = i+1;
            while(start>=0 && end<n && s.charAt(start)==s.charAt(end)){
                start--;
                end++;
                count++;
            }
        }
        return count;
        
    }
}
