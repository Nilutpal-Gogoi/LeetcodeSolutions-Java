//https://leetcode.com/problems/richest-customer-wealth/
package easy;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int max_amount = 0;
        int row = accounts.length;
        for(int i = 0; i<row; i++){
            int sum = 0;
            int col = accounts[i].length;
            for(int j = 0;j < col; j++){
                sum += accounts[i][j];
            }
            if(sum > max_amount) max_amount = sum;
        }
        return max_amount;
    }
}
