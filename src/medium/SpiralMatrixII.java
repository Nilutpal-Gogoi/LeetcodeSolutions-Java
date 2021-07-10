package medium;

import java.util.Arrays;

public class SpiralMatrixII {
    public static void main(String[] args){
        int n = 3;
        int[][] result = solution(n);
        System.out.println(Arrays.deepToString(result));
    }
    public static int[][] solution(int n){
        int[][] result = new int[n][n];
        int top = 0, bottom = n-1, left = 0, right=n-1;
        int index = 0;
        while(n*n>index){
            if(top>bottom)
                break;
            for(int i=left;i<=right;i++){
                result[top][i] = index+1;
                index++;
            }
            top++;

            if(left>right)
                break;
            for(int i=top;i<=bottom;i++){
                result[i][right] = index+1;
                index++;
            }
            right--;

            if(top>bottom)
                break;
            for(int i=right;i>=left;i--){
                result[bottom][i] = index+1;
                index++;
            }
            bottom--;

            if(left>right)
                break;
            for(int i = bottom;i>=top;i--){
                result[i][left] = index+1;
                index++;
            }
            left++;
        }
        return result;
    }
}
