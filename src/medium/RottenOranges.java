package medium;

import java.util.*;


public class RottenOranges {
    public int[] xdir = {-1, 0, 1, 0};
    public int[] ydir = {0, 1, 0, -1};
    
	public class OPair{
		int r;
		int c;
		int t;
		
		public OPair(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
    public int orangesRotting(int[][] grid) {
        Queue<OPair> qu = new LinkedList<>();
        
        // 1. travel on grid, add rotted oranges in queue, and count oranges
        int orange = 0;
        for(int i = 0; i < grid.length ; i++) {
        	for(int j = 0 ; j < grid[0].length ; j++) {
        		if(grid[i][j] == 2) {
        			qu.add(new OPair(i, j, 0));
        		}
        		
        		if(grid[i][j] == 1 || grid[i][j] == 2) {
        			orange++;
        		}
        	}
        }
        
        //2. apply BFS and find remaining orange count and time as well 
        int time = 0;
        
        while(qu.size() > 0) {
        	OPair rem = qu.remove();
        	if(grid[rem.r][rem.c] == -2) {
        		continue;
        	}
        	grid[rem.r][rem.c] = -2;
        	
        	orange--;
        	time = rem.t;
        	
        	for(int d = 0; d < 4; d++) {
        		int x = rem.r + xdir[d];
        		int y = rem.c + ydir[d];
        		
        		if(x >= 0 && x < grid.length &&  y >= 0 && y < grid[0].length && grid[x][y] == 1) {
        			qu.add(new OPair(x, y, rem.t+1));
        		}
        	}
        }
        
        return orange == 0 ? time : -1;
    }
}
