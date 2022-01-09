package medium;

import java.util.*;

public class ReverseSubstringParantheses {
	public String reverseParentheses(String s) {
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(ch!= ')') {
				st.push(ch);
			}else {
				StringBuilder str = new StringBuilder();
				while(st.peek() != '(') {
					str.append(st.pop());
				}
				st.pop();
				for(int j=0; j<str.length(); j++) {
					st.push(str.charAt(j));
				}
			}
		}
		
		StringBuilder str = new StringBuilder();
		while(st.size() > 0) {
			str.append(st.pop());
		}
		str.reverse();
		return str.toString();
	}
}
