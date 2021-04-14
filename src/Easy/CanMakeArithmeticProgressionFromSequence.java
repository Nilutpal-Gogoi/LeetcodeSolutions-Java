//https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/submissions/
package Easy;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {
    public static void main(String[] args) {
        int[] arr = {1,2,4};
        System.out.println(canMakeArithmeticProgression(arr));
    }
    public static boolean canMakeArithmeticProgression(int[] arr){
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        if(arr.length>2){
            for(int i=2;i<arr.length;i++){
                if(arr[i]-arr[i-1] != diff)
                    return false;
            }
        }
        else{
            if(arr[0] == arr[1])
                return false;
            else
                return true;
        }
        return true;
    }
}
