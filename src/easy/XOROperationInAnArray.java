// https://leetcode.com/problems/xor-operation-in-an-array/
package easy;

public class XOROperationInAnArray {
    public static int xorOperation(int n, int start) {
        int xor = 0;
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = (start+(2*i));
            xor = xor ^ nums[i];
        }
        return xor;
    }
}
