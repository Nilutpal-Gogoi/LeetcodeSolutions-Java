package medium;

public class NumberOfIslands {
	public static int[] xdir = {-1, 0, 1, 0};
	public static int[] ydir = {0, 1, 0, -1};
    public static void getCount(char[][] graph, int n, int m){
        graph[n][m] = 'a';
        for(int d=0; d<xdir.length ; d++) {
			int r = n + xdir[d];
			int c = m + ydir[d];
			if(r>=0 && r<graph.length && c>=0 && c<graph[0].length && graph[r][c] == '1') {
				getCount(graph, r, c);
			}
		}
    }
    
    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(n == 0 || grid == null){
            return 0;
        }
        
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    getCount(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
		char[][] graph = {
				  {'1','1','1','1','0'},
				  {'1','1','0','1','0'},
				  {'1','1','1','0','0'},
				  {'0','0','0','0','0'}
		};
		int res = numIslands(graph);
		System.out.println(res);
    }
}
