package medium;

public class NumberOfEnclaves {
    public int[] xdir = {-1, 0, 1, 0};
    public int[] ydir = {0, 1, 0, -1};
    
	public void numEnclave_dfs(int[][] grid, int row, int col) {
        grid[row][col] = 0;
        for(int d = 0; d<4; d++){
            int rdir = row + xdir[d];
            int cdir = col + ydir[d];
            if(rdir >=0 && rdir < grid.length && cdir >= 0 && cdir < grid[0].length && grid[rdir][cdir] == 1){
            	numEnclave_dfs(grid, rdir, cdir);
            }
        }
	}
	public int numEnclaves(int[][] grid) {
		// for 0 th row
		for(int c=0; c<grid[0].length; c++) {
			if(grid[0][c] == 1) {
				numEnclave_dfs(grid, 0, c);
			}
		}
		
		// for last row
		for(int c=0; c<grid[0].length; c++) {
			if(grid[grid.length-1][c] == 1) {
				numEnclave_dfs(grid, grid.length-1, c);
			}
		}
		
		// for 0th column
		for(int r=0; r<grid.length; r++) {
			if(grid[r][0] == 1) {
				numEnclave_dfs(grid, r, 0);
			}
		}
		
		// for last column
		for(int r=0; r<grid.length; r++) {
			if(grid[r][grid[0].length-1] == 1) {
				numEnclave_dfs(grid, r, grid[0].length-1);
			}
		}
		
		// count remaining one
		int one = 0;
		for(int r= 0; r<grid.length; r++) {
			for(int c = 0; c<grid[0].length; c++) {
				if(grid[r][c] == 1) {
					one++;
				}
			}
		}
		return one;
	}
}
