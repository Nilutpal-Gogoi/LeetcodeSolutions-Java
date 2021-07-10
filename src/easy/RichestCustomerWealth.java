//https://leetcode.com/problems/richest-customer-wealth/
package easy;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int max_wealth = 0,temp = 0;
        int noOfCustomers = accounts.length;
        int noOfBanks = accounts[0].length;
        for(int i=0;i<noOfCustomers;i++){
            temp = 0;
            for(int j=0;j<noOfBanks;j++){
                temp += accounts[i][j];
            }
            if(temp>max_wealth){
                max_wealth = temp;
            }
        }
        return max_wealth;
    }
}
