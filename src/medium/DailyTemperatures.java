package medium;

import java.util.*;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(int i=1;i<T.length;i++){
            while(st.size()>0 && T[st.peek()]<T[i]){
                res[st.pop()] = i;
            }
            st.push(i);
        }
        
        while(st.size()>0){
            int index = st.pop();
            res[index] = index;
        }
        
        for(int i=0; i<res.length; i++){
            res[i] = res[i]-i;
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
		int[] res = dailyTemperatures(arr);
		System.out.println(Arrays.toString(res));
	}

}
