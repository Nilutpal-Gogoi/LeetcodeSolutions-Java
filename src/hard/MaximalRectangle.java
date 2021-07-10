package hard;

import java.util.Stack;

public class MaximalRectangle {

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
  
    public static int largestAreaRectangle(int[] arr){
        int area = 0;
        
        int[] lsi = leftSmallestIndex(arr);
        int[] rsi = rightSmallestIndex(arr);
        
        for(int i=0; i<lsi.length; i++){
            int width = rsi[i]-lsi[i]-1;
            int height = arr[i];
            
            area = Math.max(area, width*height);
        }
        return area;
    }
    
    public static int maximalRectangle(char[][] matrix) {
    	if(matrix.length == 0 || matrix[0].length == 0) {
    		return 0;
    	}
    	int[] arr = new int[matrix[0].length];
    	int res = 0;
    	for(int i=0; i<matrix.length; i++) {
//    		prepare arr for largest area histogram
    		for(int j=0; j<matrix[0].length; j++) {
    			if(matrix[i][j] == '0') {
    				arr[j] = 0;
    			} else {
    				arr[j] += matrix[i][j] - '0';
    			}
    		}
    		res = Math.max(res, largestAreaRectangle(arr));
    	}
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
