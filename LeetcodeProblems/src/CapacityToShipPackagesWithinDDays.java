/*
 * 
 * 1014. Capacity To Ship Packages Within D Days
 * 
 * A conveyor belt has packages that must be shipped from one port to another within D days.

 * The i-th package on the conveyor belt has a weight of weights[i].  Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.
 */



public class CapacityToShipPackagesWithinDDays {

	public int shipWithinDays(int[] weights, int D) {
	       
        int n = weights.length;
        
        int low = weights[0];
        int hi = weights[0];
        for(int i:weights)
        {
            low = Math.max(low, i);
            hi = hi + i;
        }
        
        while(low < hi){
            int mid  = (low+hi)/2;
            if(canSend(weights, D, mid)) 
                hi = mid;
            else
                low = mid+1;
        }
        return low;
    }
    
    public boolean canSend(int[] weights, int D, int cap){
        
        int cd = 0;
        int ans = 1;
        for (int i = 0; i < weights.length; i++) {
            if (cd + weights[i] > cap) {
                ans++;
                cd = 0;
            }
            cd += weights[i];
        }
        return ans <= D;
        
    }
}
