package easy;

public class AddStrings {
	public static String addStrings(String num1, String num2) {
		int i =num1.length()-1;
		int j = num2.length()-1;
		int carry = 0;
		StringBuilder res = new StringBuilder();
		while(i>=0 || j>=0) {
            int n1 = i>=0 ? (num1.charAt(i)-'0') : 0;
            int n2 = j >= 0 ? (num2.charAt(j) - '0') : 0;
			int a1 =n1+n2+carry ;
			if(a1 > 9) {
				res.insert(0,(a1%10));
				carry = a1/10;
			}else {
				res.insert(0,(a1%10));
				carry = 0;
			}
			i--;
			j--;
		}		
		
		if(carry!=0) {
			res.insert(0, carry);
		}
		
		return res.toString();
	}
	
	public static void main(String[] args) {
		String num1 = "0";
		String num2 = "0";
		System.out.println(addStrings(num1, num2));
	}
}
