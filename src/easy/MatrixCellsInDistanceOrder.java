package easy;

import java.util.*;

public class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
    	int[][] res = new int[rows*cols][2];
    	for(int i = 0; i<rows; i++) {
    		for(int j = 0; j<cols; j++) {
    			int bno = i*cols+j;
    			res[bno][0] = i;
    			res[bno][1] = j;
    		}
    	}
    	
    	Arrays.sort(res,(a, b) -> {
    		int d1 = Math.abs(a[0]-rCenter)+Math.abs(a[1]-cCenter);
    		int d2 = Math.abs(b[0]-rCenter)+Math.abs(b[1]-cCenter);
    		
    		return d1-d2;
    	});
    	
    	return res;
    }
    
    
    // -------- BFS approach ----------
    public class Pair{
    	int x;
    	int y;
    	public Pair(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
    
    public int[] xdir = {0, 0, -1, 1};
    public int[] ydir = {-1, 1, 0, 0};
    public int[][] allCellsDistOrder_(int rows, int cols, int rCenter, int cCenter) {

    	int[][] res = new int[rows*cols][2];
    	Queue<Pair> qu = new ArrayDeque<>();
        boolean[][] flag = new boolean[rows][cols];
    	qu.add(new Pair(rCenter, cCenter));
    	flag[rCenter][cCenter] = true;
    	int i = 0;
    	while(!qu.isEmpty()) {
    		int size = qu.size();
    		while(size-- > 0) {
    			Pair rem = qu.remove();
    			res[i][0] = rem.x;
    			res[i][1] = rem.y;
    			i++;
    			for(int j = 0; j<4; j++) {
    				int x = rem.x + xdir[j];
    				int y = rem.y + ydir[j];
    				if(x >= 0 && y >= 0 && x < rows && y < cols && !flag[x][y]) {
    					qu.add(new Pair(x,y));
                        flag[x][y] = true;
    				}
    			}
                
    		}
    	}
    	
    	return res;
    }
}
