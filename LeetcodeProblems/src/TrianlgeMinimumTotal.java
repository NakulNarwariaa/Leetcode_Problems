import java.util.List;

/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

*/

public class TrianlgeMinimumTotal {
	
	public int minimumTotal(List<List<Integer>> triangle) {
        int[][] q = new int[triangle.size()][triangle.size()];
        int lastUsedIndex = 0;
        int minCost = 0;
        int i=0;
        int min = 0;
        for(i=0;i<q.length;i++){
            min = Integer.MAX_VALUE;
            for(int j=0;j<triangle.get(i).size();j++){
                if(i == 0){
                    q[i][0] = triangle.get(i).get(0);
                    min = q[i][0];
                    break;
                }
                if(j == triangle.get(i).size()-1)
                    q[i][j] = triangle.get(i).get(j) + q[i-1][j-1];
                
                else if (j== 0)
                    q[i][j] = triangle.get(i).get(j) + q[i-1][j];
                
                else
                    q[i][j] = triangle.get(i).get(j) + (int)Math.min(q[i-1][j-1],q[i-1][j]);
                    if(min > q[i][j])
                        min = q[i][j];
                
                    
            }
        }
        
        return  min;
    }

}
