package medium;

import java.util.Stack;


public class OnlineStockSpan {
	private class Pair{
		int val;
		int indx;
		
		Pair(int val, int indx) {
			this.val = val;
			this.indx = indx;
		}
	}
	
	private int indx;
	
	private Stack<Pair> st;
	
	public OnlineStockSpan() {
		st = new Stack<>();
		indx = -1;
		st.push(new Pair(Integer.MAX_VALUE, -1));
		indx++;
	}
	
	public int next(int price) {
		
		while(st.size() > 0 && st.peek().val <= price) {
			st.pop();
		}
		
		int span = indx - st.peek().indx;
		st.push(new Pair(price, indx));
		indx++;
		
		return  span;
	}
	
}
