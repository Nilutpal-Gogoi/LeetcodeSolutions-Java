package Medium;

public class Pow {
	
    public static double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        
        if(n<0){
            double xn = myPow(x,n/2);
            return n%2 == 0? (xn*xn) : (xn*xn/x);
        }else{
            double xn = myPow(x , n/2);
            return n%2==0? xn*xn : xn*xn*x;    
        }
        
    }

	public static void main(String[] args) {

		double x = 2.00000;
		int n = -2;
		
		System.out.println(myPow(x,n));
	}

}
