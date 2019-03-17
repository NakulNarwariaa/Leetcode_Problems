import java.util.Arrays;
import java.util.HashMap;

/*
 * 132. Palindrome Partitioning II
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 */


public class PalindromePartitioning {
	
	HashMap<String,Integer> memo = new HashMap<>();
    
	
	public int minCut(String s) {
        
        int n = s.length();
        
        if(n==1)
            return 0;
        if(n==0)
            return -1;
        
        boolean[][] dp = new boolean[n][n];
        int[] cut = new int[n];
        Arrays.fill(cut,n-1);
        cut[n-1] = 0; //(cut[n]) => number of cuts in [n,end]
        dp[n-1][n-1] = true;
        
        
        for(int start=n-1;start >= 0 ; start--){
            for(int end=start; end<n; end++){
              
                //single character string
                if(start==end){
                    dp[start][end]=true;
                   
                }
                          
                //2 character string
                else if(end-start==1 && (s.charAt(start)==s.charAt(end)))
                        dp[start][end]=true;
                    
                // bigger strings
                else if(s.charAt(start)==s.charAt(end) && dp[start+1][end-1])
                    dp[start][end]=true;
                        
                
                int nextCuts = end==n-1 ? 0 : 1+ cut[end+1];
                
                if (dp[start][end])    
                    cut[start] = Math.min(cut[start],0 + nextCuts);
                else
                    cut[start] = Math.min(cut[start],end-start + nextCuts);
                
            }
        }
       
        return cut[0];
        
    }
	
	
	
	
    public int alternateSol(String s) {
        
        int n = s.length();
        
        if(n==1)
            return 0;
        if(n==0)
            return -1;
        int out = n-1;
        
        //for odd
        for(int i= 0;i< n;i++){
            
            int start = i; 
            int end = i;
            int tmp = 0;
            while(start>=0 && end < n && s.charAt(start)==s.charAt(end)){
                
                String startingString = s.substring(0,start);
                String endingString = s.substring(end+1);
                if(start == 0 && end == n-1){
                    memo.put(s,0);
                    return 0;
                }
                
                    
                else if(start<=0)
                    tmp = memo.get(endingString)!=null? memo.get(endingString) + 1 : alternateSol(endingString)+1;
                
                else if(end>=n-1)
                    tmp = memo.get(startingString)!=null? memo.get(startingString) + 1 : alternateSol(startingString)+1;
                
                else{
                    int first = memo.get(startingString)!=null? memo.get(startingString) + 1 : alternateSol(startingString)+1;
                    
                    int second = memo.get(endingString)!=null? memo.get(s.substring(end+1)) + 1: alternateSol(endingString)+1;
                    
                    tmp = first+ second + 2;
                  
                }
                    
                
                if(tmp<out)
                    out =tmp;
                start--;
                end++;          
            }
        }
        
        //for even
        for(int i= 0;i< n-1;i++){
            
            int start = i; 
            int end = i+1;
            int tmp = 0;
            while(start>=0 && end < n && s.charAt(start)==s.charAt(end)){
                
                String startingString = s.substring(0,start);
                String endingString = s.substring(end+1);
                if(start == 0 && end == n-1){
                    memo.put(s,0);
                    return 0;
                }
                    
                else if(start<=0)
                    tmp = memo.get(endingString)!=null? memo.get(endingString) + 1 : alternateSol(endingString)+1;
                
                else if(end>=n-1)
                    tmp = memo.get(startingString)!=null? memo.get(startingString) + 1 : alternateSol(startingString)+1;
                
                else{
                    int first = memo.get(startingString)!=null? memo.get(startingString) + 1 : alternateSol(startingString)+1;
                    
                    int second = memo.get(endingString)!=null? memo.get(s.substring(end+1)) + 1: alternateSol(endingString)+1;
                    
                    tmp = first+ second + 2;
                 
                }
                    
                
                if(tmp<out)
                    out =tmp;
                start--;
                end++;          
            }
        }
        memo.put(s,out);
        return out;
        
    }
    

}
