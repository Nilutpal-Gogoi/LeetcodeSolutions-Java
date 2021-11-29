package easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        
        int temp = x;
        int ans = 0;
        while(temp!= 0){
            ans = ans*10 + temp%10;
            temp /= 10;
        }
        return ans==x ? true:false;
    }
}
