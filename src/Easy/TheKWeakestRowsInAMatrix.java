//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TheKWeakestRowsInAMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        System.out.println(Arrays.toString(kWeakestRows(mat, 3)));
    }
    public static int[] kWeakestRows(int[][] mat, int k){
        int[] res = new int[mat.length];
        int[] arr = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<mat.length;i++){
            int count = 0;
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j] == 1)
                    count++;
            }
            res[i] = count;
        }
        int m = 0;
        while(m<k){
            int minPos = 0;
            for(int j =0;j<res.length;j++){
                if(res[j]<res[minPos]){
                    minPos = j;
                }
            }
            arr[m] = minPos;
            res[minPos] = Integer.MAX_VALUE;
            m++;
        }
        return arr;
    }
}
