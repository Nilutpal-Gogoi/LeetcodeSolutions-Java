package easy;

import java.util.*;

public class ValidParenthesis {
    public boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
		for(int i = 0 ; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == ' ') {
				continue;
			}
			if(ch == '[' || ch == '{' || ch == '(') {
				st.push(ch);
			} else if(ch == ']') {
				if(st.size() == 0 || st.peek() != '[') {
					return false;
				}else {
					st.pop();
				}
			} else if(ch == ')'){
				if(st.size() == 0 || st.peek() != '(') {
					return false;
				}else {
					st.pop();
				}
			} else if(ch == '}') {
				if(st.size() == 0 || st.peek() != '{') {
					return false;
				}else {
					st.pop();
				}
			} else {
				continue;
			}
			
		}
		
		return st.size() == 0;
    }
}
