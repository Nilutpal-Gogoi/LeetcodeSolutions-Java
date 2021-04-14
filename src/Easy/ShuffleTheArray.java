// https://leetcode.com/problems/shuffle-the-array/
package Easy;

public class ShuffleTheArray {
    public static int[] shuffle(int[] nums, int n) {
        int a = 0, b=1;
        int[] result = new int[nums.length];
        for(int i=0;i<n;i++){
            result[a] = nums[i];
            result[b] = nums[i+n];
            a += 2;
            b += 2;
        }
        return result;
    }
}
