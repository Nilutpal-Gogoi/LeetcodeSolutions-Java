package easy;

public class GuessNumberHigherOrLower {
    public static int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        int res = 0;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int temp = guess(mid);
            if(temp == 1){
                lo = mid+1;
                continue;
            } else if(temp == -1){
                hi = mid-1;
                continue;
            } else if(temp == 0) {
                return mid;
            }
        }
        return res;
    }
    
    static int pn = 0; //picked number
    public static int guess(int val) {
      if (val == pn) {
        return 0;
      }
      else if (val < pn) {
        return 1;
      }
      else {
        return -1;
      }
    }

    public static void solve(int n, int pick) {
      pn = pick;
      System.out.println(guessNumber(n));
    }
}
