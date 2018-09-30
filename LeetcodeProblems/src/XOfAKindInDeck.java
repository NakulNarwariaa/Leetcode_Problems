import java.util.HashMap;

/*
 * In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

Each group has exactly X cards.
All the cards in each group have the same integer.

 */


public class XOfAKindInDeck {

	public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length==1)
            return false;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0;i<deck.length;i++){
            if(map.get(deck[i])==null)
                map.put(deck[i],1);
            else
                map.put(deck[i],map.get(deck[i])+1);
        }
       
        int gcd=map.get(deck[0]);
        for(int i:map.values()){
            gcd = gcd(gcd,i); 
            
            System.out.println(i+" "+gcd);
        }
        
        if(gcd<=1)
            return false;
        else 
            return true;
    }
    
    public int gcd(int n1, int n2){
        int gcd=1;
        for(int i = 1; i <= n1 && i <= n2; ++i)
        {
            if(n1 % i==0 && n2 % i==0)
                gcd = i;
        }
        return gcd;
    }
}
