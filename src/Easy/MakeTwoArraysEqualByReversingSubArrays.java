//https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/

package Easy;

import java.util.Arrays;

public class MakeTwoArraysEqualByReversingSubArrays {
    public static void main(String[] args) {
        int[] target = {3,7,9};
        int[] arr = {3,7,11};
        System.out.println(canBeEqual(target , arr));
    }
    public static boolean canBeEqual(int[] target, int[] arr){
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
