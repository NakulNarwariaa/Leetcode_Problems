/*
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * Example:
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 */


public class UglyNumber {

	public int nthUglyNumber(int n) {
        int[] q = new int[n];
        q[0] =1;
        int twoMultiples = 2, threeMultiples =3, fiveMultiples = 5;
        int two =0, three = 0, five = 0;
        for(int i=1;i<n;i++){
            int min = (int) Math.min((int) Math.min(twoMultiples, threeMultiples), fiveMultiples );
            q[i] = min;
            if( twoMultiples == min)
            {
                two++;
                twoMultiples = 2*q[two];
            }
            if( threeMultiples == min){
                three++;
                threeMultiples = 3*q[three];
            } 
            if( fiveMultiples == min){
                five++;
                fiveMultiples = 5*q[five];
                
            }
                
        }
        return q[n-1];
    }
}
