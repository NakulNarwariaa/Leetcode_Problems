import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Prob 909
 * On an N x N board, the numbers from 1 to N*N are written boustrophedonically starting from the bottom left of the board, and alternating direction each row.  For example, for a 6 x 6 board, the numbers are written as follows:

36 35 34 33 32 31
25 26 27 28 29 30
24 23 22 21 20 19
13 14 15 16 17 18
12 11 10 09 08 07
01 02 03 04 05 06
You start on square 1 of the board (which is always in the last row and first column).  Each move, starting from square x, consists of the following:

You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6, provided this number is <= N*N.
If S has a snake or ladder, you move to the destination of that snake or ladder.  Otherwise, you move to S.
A board square on row r and column c has a "snake or ladder" if board[r][c] != -1.  The destination of that snake or ladder is board[r][c].

Note that you only take a snake or ladder at most once per move: if the destination to a snake or ladder is the start of another snake or ladder, you do not continue moving.

Return the least number of moves required to reach square N*N.  If it is not possible, return -1.
 */

public class SnakesAndLadders {

	public int snakesAndLadders(int[][] board) {
	       int n= board.length;
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        map.put(1,0);
	        Queue<Integer> q = new LinkedList<Integer>();
	        q.add(1);
	        while(!q.isEmpty()){
	            int s = q.remove();
	            if(s==n*n) return map.get(s);
	            for(int i=s+1;i<=(int)Math.min(s+6,n*n);i++){
	                int rc = get(i, n);
	                int r = rc / n, c = rc % n;
	                int s2 = board[r][c]==-1?i:board[r][c];
	                if(map.get(s2)==null){
	                    map.put(s2,map.get(s)+1);
	                    q.add(s2);
	                }
	            }
	        }
	        return -1;
	        
	    }
	   
	    public int get(int s, int N) {
	        // Given a square num s, return board coordinates (r, c) as r*N + c
	        int quot = (s-1) / N;
	        int rem = (s-1) % N;
	        int row = N - 1 - quot;
	        int col = row % 2 != N % 2 ? rem : N - 1 - rem;
	        return row * N + col;
	    }
}
