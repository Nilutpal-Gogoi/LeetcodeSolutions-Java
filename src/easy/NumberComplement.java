package easy;

public class NumberComplement {
    public int findComplement(int num) {
        StringBuilder biForm = new StringBuilder();
        while(num!=0){
            int rem = num%2;
            if(rem == 1){
                biForm.append(0);
            }else{
                biForm.append(1);
            }
            num = num/2;
        }
        
        biForm = biForm.reverse();
        
        
        int n = biForm.length() - 1;
        int res = 0;
        for(int i=n; i >= 0 ; i--){
            char ch = biForm.charAt(i);
            res = (int)(Math.pow(2, n-i)*(ch-'0')) + res;
        }
        
        return res;
    }
    
    // --------- Using BItManipulation ------------------
    public int findComplement2(int num) {
    	int c = 1;
    	while(c < num) {
    		c = (c<<1)+1;
    	}
    	return c ^ num;
    }
}
