package hard;

public class NumbersAtMostNGivenDigitSet {
	// ----------- Approach 1 ------------------------------
    private boolean check(int n, int[] freq){
        while(n != 0){
            if(freq[n%10] == 0) return false;
            n /= 10;
        }
        return true;
    }
    
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int count = n;
        int[] freq = new int[10];
        for(int i = 0; i<digits.length; i++){
            String str = digits[i];
            char ch = str.charAt(0);
            freq[ch-'0'] = 1;
        }
        for(int i = 1; i<=n ; i++){
            if(check(i, freq) == false){
                count--;
            }
        }
        return count;
    }
    
    public int atMostNGivenDigitSet1(String[] digits, int n) {
    	String nStr = n + "";
    	int nLen = nStr.length();
    	int noOfDigits = digits.length;
    	
    	int total = 0;
    	
    	for(int i = 1; i<nLen; i++) {
    		total += Math.pow(noOfDigits, i);
    	}
    	
    	for(int i = 0; i<nLen ; i++) {
    		boolean hasSameNo = false;
    		for(String digit : digits) {
    			if(digit.charAt(0) < nStr.charAt(i)) {
    				total += Math.pow(noOfDigits, nLen-i-1);
    			}else if(digit.charAt(0) == nStr.charAt(i)) {
    				hasSameNo = true;
    				if(i == nLen-1) {
    					total++;         // ["3", "4"] 4
    				}
    			}
    		}
    		if(!hasSameNo) {
    			return total;
    		}
    	}
    	
    	
    	return total;
    }
}
