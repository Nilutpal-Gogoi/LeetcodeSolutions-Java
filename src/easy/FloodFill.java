package easy;

import java.util.*;

public class FloodFill {
	public static int[] x = {-1, 0, 1, 0};
	public static int[] y = {0, -1, 0, 1};
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        
       solution(image, sr, sc, newColor);
       return image;
    }
    
    public static void solution(int[][] image, int sr, int sc , int newColor){
        int c = image[sr][sc];
    	int n = image.length;
    	int m = image[0].length;
    	image[sr][sc] = -1;
    	
    	for(int i=0; i<4; i++) {
    		int xdir = sr + x[i];
    		int ydir = sc + y[i];
    		if(xdir >= 0 && xdir < n && ydir >= 0 && ydir < m && image[xdir][ydir] == c && image[xdir][ydir] != -1) {
    			solution(image, xdir, ydir, newColor);
    		}
    	}
    	image[sr][sc] = newColor;
    }
    
    public static void main(String[] args) {
//    	int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
    	int[][] image = {{0,0,0},{0,0,0}};
    	int[][] arr = floodFill(image, 1, 1, 2);
    	for(int i=0; i<arr.length; i++) {
    		for(int j=0; j<arr[0].length; j++) {
    			System.out.print(arr[i][j]+"\t");
    		}
    		System.out.println();
    	}
    }
}
