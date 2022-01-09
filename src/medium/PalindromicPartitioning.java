package medium;

import java.util.*;

public class PalindromicPartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0) {
        	return res;
        }
        
        helper(res, new ArrayList<>(), s);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> currList, String s) {
    	if(s.length() == 0) {
    		res.add(new ArrayList<>(currList));
    		return;
    	}
    	
    	for(int i = 0; i<s.length(); i++) {
    		String str = s.substring(0, i+1);
    		if(isPalindrome(str)) {
    			currList.add(str);
    			String remStr = s.substring(i+1, s.length());
    			helper(res, currList, remStr);
    			currList.remove(currList.size() - 1);
    		}
    	}
    }
    
    private boolean isPalindrome(String s) {
    	String revStr = new StringBuilder(s).reverse().toString();
    	return s.equals(revStr);
    }
}
