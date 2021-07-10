// https://leetcode.com/problems/flipping-an-image/

package easy;

public class FlippingAnImage {
    public static void main(String[] args){
        int[][] arr = {{1, 1, 0},{ 1, 0, 1 },{ 0, 0, 0 }};
        System.out.println(flipAndInvertImage(arr));
    }
    public static int[][] flipAndInvertImage(int[][] A){
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j] == 0){
                    A[i][j] = 1;
                }
                else{
                    A[i][j] = 0;
                }
            }
        }
        for(int i=0;i<A.length;i++){
            int start = 0;
            int end = A[0].length-1;
            while(start<end){
                if(A[i][start] != A[i][end]){
                    int temp = A[i][start];
                    A[i][start] = A[i][end];
                    A[i][end] = temp;
                }
                start++;
                end--;
            }
        }
        return A;
    }
}
