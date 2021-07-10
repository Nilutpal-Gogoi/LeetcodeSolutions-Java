package hard;

import java.util.*;

public class LargestRectangleHistogram {

    
	public static int[] leftSmallestIndex(int[] arr){
	    int[] res = new int[arr.length];
	    
	    Stack<Integer> st = new Stack<>();
	    st.push(arr.length-1);
	    
	    for(int i = arr.length-2; i>=0; i--){
	        while(st.size()>0 && arr[st.peek()]>arr[i]){
	            res[st.pop()] = i;
	        }
	        st.push(i);
	    }
	    
	    while(st.size()>0){
	        res[st.pop()] = -1;
	    }
	    
	    return res;
	}

	public static int[] rightSmallestIndex(int[] arr){
	    int[] res = new int[arr.length];
	    
	    Stack<Integer> st = new Stack<>();
	    st.push(0);
	    
	    for(int i = 1; i<arr.length; i++){
	        while(st.size()>0 && arr[st.peek()]>arr[i]){
	            res[st.pop()] = i;
	        }
	        st.push(i);
	    }
	    
	    while(st.size()>0){
	        res[st.pop()] = arr.length;
	    }
	    
	    return res;
	}
	
	public static int largestRectangleArea(int[] heights) {
	    int area = 0;
	    
	    int[] lsi = leftSmallestIndex(heights);
	    int[] rsi = rightSmallestIndex(heights);
	    
	    for(int i=0; i<lsi.length; i++){
	        int width = rsi[i]-lsi[i]-1;
	        int height = heights[i];
	        
	        area = Math.max(area, width*height);
	    }
	    return area;
	}
	
	public static void main(String[] args) {
    	int[] a = { 6,2,5,4,5,1,6};
        
        int res = largestRectangleArea(a);
        System.out.println(res);
	}

}
