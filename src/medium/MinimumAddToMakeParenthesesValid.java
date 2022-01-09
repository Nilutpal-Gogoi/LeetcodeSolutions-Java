package medium;

import java.util.*;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack();
    	int res = 0;
    	for(int i = 0; i<s.length(); i++) {
    		char ch = s.charAt(i);
    		if(st.size() > 0 && ch == ')' && st.peek() == '('){
    			st.pop();
    		} else {
    			st.push(ch);
    		}
    	}
    	
    	return st.size();
    }
}
