package easy;

public class ANumberAfterADoubleReversal {
	public boolean isSameAfterReversals(int num) {
		int reversed1 = reverse(num);
		int reversed2 = reverse(reversed1);
		
		return reversed2 == num;
	}
	
	public int reverse(int num) {
		int res = 0;
		while(num != 0) {
			res = res*10 + num%10;
			num /= 10;
		}
		return res;
	}
	
	// ------------ 2nd approach -
	public boolean isSameAfterReversals1(int num) {
		return (num == 0)||(num%10 == 0);
	}
}
