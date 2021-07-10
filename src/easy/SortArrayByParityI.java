//https://leetcode.com/problems/sort-array-by-parity/
package easy;

import java.util.Arrays;

public class SortArrayByParityI {
    public static void main(String[] args){
        int[] arr = {3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(arr)));
    }

    public static int[] sortArrayByParity(int[] A){
        Arrays.sort(A);
        int start = 0;
        int end = A.length-1;
        while(start<end){
            if(A[start]%2!=0) {
                if(A[end] % 2 == 0) {
                    int temp = A[start];
                    A[start] = A[end];
                    A[end] = temp;
                }
                end--;
            }
            else{
                start++;
            }

        }
        return A;
    }
}
