package easy;

import java.util.HashSet;

public class SumOfUniqueElements {
    public static void main(String[] args){
        int[] arr = {1,2,3,2};
        System.out.println(sumOfUnique(arr));
    }
    public static int sumOfUnique(int[] nums){
        int res = 0;
        for(int i=0;i<nums.length;i++){
            boolean flag = false;
            for(int j=0;j<nums.length; j++){
                if(i==j)
                    continue;
                if(nums[i] == nums[j]) {
                    flag = true;
                    break;
                }
            }
            if(!flag){
                res += nums[i];
            }
        }
        return res;
    }
}
