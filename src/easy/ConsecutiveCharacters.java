package easy;

public class ConsecutiveCharacters {
    public static int maxPower(String s) {
        int res = 1;
    	int i = 0;
    	while(i<s.length()-1) {
    		int j = 1;
    		while(i < s.length()-1 && s.charAt(i)==s.charAt(i+1)) {
    			j++;
    			i++;
    		}
    		
    		res = Math.max(res, j);
    		i++;
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	String str = "abbcccddddeeeeedcba";
    	System.out.println(maxPower(str));
    }
}
