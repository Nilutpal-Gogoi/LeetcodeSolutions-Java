package medium;

import java.util.*;

public class ScoreOfParenthesis {
	public int scoreOfParenthesis(String s) {
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == '(') {
				st.push(-1);
			}else if(st.peek() == -1) {
				st.pop();
				st.push(1);
			} else {
				int sum = 0;
				while(st.peek() != -1) {
					sum += st.pop();
				}
				st.pop();
				st.push(2*sum);
			}
		}
		
		int add = 0;
		while(st.size() > 0) {
			add += st.pop();
		}
		return add;
	}
}
