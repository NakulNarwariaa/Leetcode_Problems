import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContinuosSubsetSumMultipleOfK {
	
	/*
	 * Write a function to find number of contiguous subsets of an array
	 * whose sum is a multiple of k.
	 */
	
    public static void main(String args[]){

        ArrayList<Integer> nums = new ArrayList<>(){
            {
                add(7);
                add(4);
                add(1);
                add(2);
                add(8);
                add(3);
            }
        };
        System.out.println(countSubsets(nums,7));

    }

    public static int countSubsets(List<Integer> nums, int k){
        int count =0 ;
        HashMap<Integer,Integer> sums  = new HashMap<Integer,Integer>();
        int sum = 0;
        sums.put(0,1);
        for(int i=0;i<nums.size();i++){

            sum+=nums.get(i);
            sums.put(sum,1);

            for(int j = sum - (sum%k);j>0;j=j-k){
                if(sums.get(sum-j)!=null)
                {
                    System.out.println(sum+" -  "+(sum-j));
                    count++;
                }
            }

        }
        System.out.println(sums);
        return count;
    }


}
