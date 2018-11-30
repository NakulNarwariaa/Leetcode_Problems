/*
 * Problem 64.
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */

public class MinimumPathSum {
	
	public int minPathSum(int[][] grid) {
        int[][] q = new int[grid.length][grid[0].length];
        
        for(int i=0; i<grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                
                if(i==0 && j == 0)
                    q[i][j] = grid[i][j];
                else if( i==0)
                    q[i][j] = q[i][j-1] + grid[i][j];
                else if( j==0)
                    q[i][j] = q[i-1][j] + grid[i][j];
                else{
                    q[i][j] = grid[i][j] + (int)Math.min(q[i-1][j],q[i][j-1]);
                }
                
            }
            
        }
        
        return q[grid.length-1][grid[0].length-1];
    }
}
