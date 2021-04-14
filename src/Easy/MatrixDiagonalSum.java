// https://leetcode.com/problems/matrix-diagonal-sum/

package Easy;

public class MatrixDiagonalSum {
    public static void main(String[] args){
        int[][] arr = {{5}}; //{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        System.out.println(diagonalSum(arr));
    }
    public static int diagonalSum(int[][] mat){
        int sum = 0;
        int start = 0, end=mat.length-1;
        while(start<=end){
            if(start == end){
                sum += mat[start][end];
            }
            else{
                sum += mat[start][start];
                sum += mat[start][end];
                sum += mat[end][start];
                sum += mat[end][end];
            }
            start++;
            end--;
        }
        return sum;
    }
}
