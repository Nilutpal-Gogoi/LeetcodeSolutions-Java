package Easy;

public class FindNumbersWithEvenNumberOfDigits {
    public static void main(String[] args){
        int[] arr = {12, 345, 2, 6, 7896};
        System.out.println(findNumbers(arr));
    }
    public static int findNumbers(int[] nums){
        int res = 0;
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            int count = 0;
            while(x!=0){
                count += 1;
                x = x/10;
            }
            if(count %2 == 0){
                res += 1;
            }
        }
        return res;
    }
}
