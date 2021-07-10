// https://leetcode.com/problems/sum-of-all-odd-length-subarrays

package easy;


public class SumOfAllOddLengthSubarrays {
    public static void main(String[] args){
        int[] arr = {1,2};
        System.out.println(sumOddLengthSubarrays(arr));
    }
    public static int sumOddLengthSubarrays(int[] arr){
        int sum = 0;
        for(int len=1; len<=arr.length; len = len+2){
            int start = 0;
            int temp = 0;
            while(start<=arr.length-len){
                for(int i=start;i<(start+len);i++){
                    temp += arr[i];
                }
                start++;
            }
            sum += temp;
        }
        return sum;
    }
}
