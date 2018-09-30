import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSubsets {


	/*
	 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a. 

Return a list of all universal words in A.  You can return the words in any order.
	 */
	
	
	
	public List<String> wordSubsets(String[] A, String[] B) {
        //create unique list of char for b 
        HashMap<Character,Integer> a = new HashMap<Character,Integer>();
        for(String b:B){
            HashMap<Character,Integer> q = new HashMap<Character,Integer>();
            for(int i=0;i<b.length();i++)
                if(q.get(b.charAt(i))==null)
                    q.put(b.charAt(i),1);
                else
                    q.put(b.charAt(i),q.get(b.charAt(i))+1);
            for(char w:q.keySet()){
                int max = q.get(w);
                if(a.get(w)!=null)
                    max = a.get(w)>q.get(w)?a.get(w):q.get(w);
                a.put(w,max);
            }
        }
        
        //match against each string in A
        ArrayList<String> out = new ArrayList<String>();
        for(String s:A){
            HashMap<Character,Integer> q = new HashMap<Character,Integer>();
            for(int i=0;i<s.length();i++)
                if(q.get(s.charAt(i))==null)
                    q.put(s.charAt(i),1);
                else
                    q.put(s.charAt(i),q.get(s.charAt(i))+1);
            boolean flag = false;
            for(char i:a.keySet()){
                if(q.get(i)==null || q.get(i)<a.get(i)){
                    flag = true;
                    break;
                }
            }
            if(!flag)
                out.add(s);  
        }
        return out;
    }
}
