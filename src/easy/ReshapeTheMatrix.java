package easy;

import java.util.*;

public class ReshapeTheMatrix {

	public static void main(String[] args) {
		int[][] nums = {{1,2},{3,4}};
		int r = 1, c = 4;
		int[][] res = matrixReshape(nums, r,c);
		System.out.println(Arrays.toString(res));
	}
	
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        int n = nums.length;
        int m = nums[0].length;
        
        if(n*m != r*c){
            return nums;
        }
        
        int col = 0;
        int row = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                res[row][col] = nums[i][j];
                col++;
                if(col == c){
                    col = 0;
                    row++;
                }
            }
        }
        return res;
    }

}
