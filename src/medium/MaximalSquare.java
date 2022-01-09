package medium;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        boolean flagOne = false;
        for(int i = m-1; i >= 0; i--) {
        	for(int j = n-1; j >= 0; j--) {
        		int ch = matrix[i][j]-'0';
                if(ch == 1) flagOne = true;
        		if(i==m-1 && j==n-1) {
        			dp[i][j] = ch;
        		}else if(i == m-1) {
        			dp[i][j] = ch;
        		}else if(j == n-1) {
        			dp[i][j] = ch;
        		}else {
        			if(ch == 0) {
        				dp[i][j] = ch;
        			}else {
            			int min = Math.min(dp[i][j+1], dp[i+1][j+1]);
            			min = Math.min(dp[i+1][j], min);
            			dp[i][j] = min+1;
            			
            			if(dp[i][j] > res) {
            				res = dp[i][j];
            			}
        			}
        		}
        	}
        }
        
        if(res == 0 && flagOne==true){
            return 1;   
        } else{
            return res*res;   
        }
    }
}
