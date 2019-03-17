/*
 * 395. Longest Substring with At Least K Repeating Characters
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) 
 * such that every character in T appears no less than k times.
 */


public class LongestSubstringWithAtLeastKRepeatingCharacters {

	
	//  public int longestSubstring(String s, int k) {
	//  int n = s.length();
	 
	//  if(n ==0 || n<k || s==null)
	//      return 0;
	 
	//  if(k==0)
	//      return n;
	 
	//  int max = 0;
	//  for(int i=0;i<=n-k;i++){
	//      if(i > 0 && s.charAt(i) == s.charAt(i-1))
	//          continue;
	//      HashMap<Character, Integer> map = new HashMap<>();
	//      HashSet<Character> incomplete = new HashSet<>();
	//      int j=i;
	//      for(j=i;j<n ; j++)
	//      {
	//          char c = s.charAt(j);
	//          if(map.get(c)==null){
	//              map.put(c,1);
	//              incomplete.add(c);
	//          }
	//          else
	//              map.put(c,map.get(c)+1);
	         
	//          if(map.get(c) >= k)
	//              incomplete.remove(c);
	//          if(incomplete.isEmpty() && j-i+1>max)
	//              max = j-i+1;  
	//      }
	//  }
	//  return max;
	 
	 
	//}
	
	public int longestSubstring(String s, int k) {
	
	 int[] count = new int[26];
	
	 for (char c : s.toCharArray()) {
	     count[c - 'a']++;
	 }
	 int start = 0;
	 int end = 0;
	 while(end < s.length()) {
	     char c = s.charAt(end);
	     if(count[c-'a'] < k) {
	         if(start == end) {
	             start++;
	         } else {
	             return Math.max(longestSubstring(s.substring(start, end), k), 
	                            longestSubstring(s.substring(end+1), k));
	         }
	     }
	     end++;
	 }
	
	 return end-start;
	}
}
