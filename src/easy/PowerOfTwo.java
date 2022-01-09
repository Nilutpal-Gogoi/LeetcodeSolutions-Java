package easy;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n==0 || n == Integer.MIN_VALUE) return false;
    	int x = n ;
    	int y = n-1;
    	
    	return (n & n-1) == 0 ? true: false;
    }
}
