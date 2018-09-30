
public class PartitionArrayIntoDisjoint {

	/*
	 * Given an array A, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.
	 */
	
	public int partitionDisjoint(int[] A) {
	    
		//a is min number from endIndex to index i
		//b is max number from startIndex to index i
        int[] a = new int[A.length];
        a[A.length-1] = A[A.length-1];
        int[] b= new int[A.length];
        b[0]=A[0];
        for(int i=A.length-2;i>=0;i--){
            if(A[i]>a[i+1])
                a[i]=a[i+1];
            else
                a[i]=A[i];
            if(A[A.length-1-i]>b[A.length-1-i-1])
                b[A.length-1-i] = A[A.length-1-i];
            else
                b[A.length-1-i] = b[A.length-1-i-1]; 
        }
       
        for(int i=0;i<A.length-1;i++)
            if(b[i]<=a[i+1])
                return i+1;
        return a.length-1;
        
	       
    }
}
