package hard;

import java.util.*;

public class PalindromicPartitioningII {
	public static int res = Integer.MAX_VALUE;
    public static int minCut(String s) {
        if(s == null || s.length() == 0 || s.length() == 1) {
        	return 0;
        }
        
        helper(new ArrayList<>(), s);
        return res;
    }
    
    
    private static void helper(ArrayList<String> currList, String s) {
    	if(s.length() == 0) {
    		System.out.println(res + " " + currList.size());
    		res = Math.min(res, currList.size());
    		return;
    	}
    	
    	for(int i = 0; i<s.length(); i++) {
    		String str = s.substring(0, i+1);
    		if(isPalindrome(str)) {
    			currList.add(str);
    			String remStr = s.substring(i+1, s.length());
    			helper(currList, remStr);
    			currList.remove(currList.size() - 1);
    		}
    	}
    }
    
    private static boolean isPalindrome(String s) {
    	String revStr = new StringBuilder(s).reverse().toString();
    	return s.equals(revStr);
    }
    
    public static void main(String[] args) {
    	String s = "aab";
    	int ans = minCut(s);
    	System.out.println(ans);
    }
}
