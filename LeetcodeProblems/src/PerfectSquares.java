import java.util.Arrays;

/*
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * Example 1:
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

public class PerfectSquares {
	public int numSquares(int n) {
        int perfectSquareIndex=2;
        int[] q = new int[n+1];
        q[1]=1;
        for(int i = 2; i<n+1;i++){
            if(i == perfectSquareIndex*perfectSquareIndex)
            {
                q[i] = 1;
                perfectSquareIndex++;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(int j=1;j<i;j++){
                if(min > q[j] + q[i-j])
                    min = q[j] + q[i-j];
            }
            q[i]= min;
        }
        System.out.println(Arrays.toString(q));
        return q[n];
    }
}
