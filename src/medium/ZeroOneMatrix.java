package medium;

import java.util.*;

public class ZeroOneMatrix {
    public int[] xdir = {-1, 0, 1, 0};
    public int[] ydir = {0, -1, 0, 1};
    
	public class Pair01{
		int x;
		int y;
		
		public Pair01(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public int[][] updateMatrix(int[][] mat){
		Queue<Pair01> qu = new LinkedList<>();
		boolean[][] vis = new boolean[mat.length][mat[0].length];
		
		// 1. travel and fill queue with initial 0
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == 0) {
					qu.add(new Pair01(i, j));
                    vis[i][j] = true;
				}
			}
		}
		
		
		// 2. Run BFS and mark level in given matrix and use a visited matrix
		int level = -1;
		while(qu.size() > 0) {
			level++;
			int size = qu.size();
			while(size-- > 0) {
				Pair01 rem = qu.remove();
				mat[rem.x][rem.y] = level;
				
				for(int d = 0; d < 4; d++) {
					int r = rem.x + xdir[d];
					int c = rem.y + ydir[d];
					
					if(r >= 0 && r < mat.length && c >= 0 && c < mat[0].length && vis[r][c] == false) {
						qu.add(new Pair01(r, c));
						vis[r][c] = true;
					}
				}
			}
		}
		
		return mat;
	}
}
