package easy;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int lo = 1;
		int hi = n;
		int res = 0;
		while(lo <= hi) {
			int mid = lo+(hi-lo)/2;
			if(isBadVersion(mid)) {
				res = mid;
				hi = mid-1;
			}else {
				lo = mid+1;
			}
		}
		return res;
    }
    
	static int bad = 0;
	public void solve(int n, int fbv) {
		bad = fbv;
		System.out.println(firstBadVersion(n));
	}
	
	public boolean isBadVersion(int val) {
		if(val >= bad) {
			return true;
		} else {
			return false;
		}
	}
}
