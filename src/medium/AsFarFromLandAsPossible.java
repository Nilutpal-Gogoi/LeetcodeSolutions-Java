package medium;

import java.util.*;

public class AsFarFromLandAsPossible {
    public int[] xdir = {-1, 0, 1, 0};
    public int[] ydir = {0, 1, 0, -1};
    
    public class pairD{
    	int x;
    	int y;
    	
    	public pairD(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
    
	public int maxDistance(int[][] grid) {
		// 1. iterate on grid and add all one's in queue and mark it as well
		Queue<pairD> qu = new LinkedList<>();
		
		for(int i = 0; i < grid.length ; i++) {
			for(int j = 0; j < grid[0].length ; j++) {
				if(grid[i][j] == 1) {
					qu.add(new pairD(i, j));
					grid[i][j] = -1;
				}
			}
		}
		
		// run BFS
        if(qu.size() == 0 || qu.size() == grid.length*grid[0].length){
            return -1;
        }
		int level = -1;
		
		while(qu.size() > 0) {
			level++;
			int size = qu.size();
			while(size-- > 0) {
				pairD rem = qu.remove();
				for(int d = 0; d < 4; d++) {
					int r = rem.x + xdir[d];
					int c = rem.y + ydir[d];
					
					if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != -1) {
						qu.add(new pairD(r, c));
						grid[r][c] = -1;
					}
				}
			}
		}
		
		return level;
	}
}











































