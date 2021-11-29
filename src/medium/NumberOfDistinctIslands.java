package medium;

import java.util.*;

public class NumberOfDistinctIslands {
    static int[] xdir = {-1, 0, 1, 0};
    static int[] ydir = {0, 1, 0, -1};
	
    static StringBuilder str;
	
    static char[] dir = {'t', 'l', 'd', 'r'};
    
	private void distinctCount(int[][] grid, int x, int y) {
		grid[x][y] = 0;
		for(int d = 0; d < 4; d++) {
			int r = x + xdir[d];
			int c = y + ydir[d];
			
			if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
				str.append(""+dir[d]);
				distinctCount(grid, r, c);
			}
		}
		str.append("z");
	}
	
	public int numberofDistinctIslands(int[][] grid) {
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i<grid.length; i++) {
			for(int j = 0; j<grid[0].length; j++) {
				if(grid[i][j] == 1) {
					str = new StringBuilder();
					distinctCount(grid, i, j);
					set.add(str.toString());
				}
			}
		}
		
		return set.size();
	}
}
