package medium;

public class JumpGameIII {
	
	public static boolean canReach(int[] arr, int start) {
		boolean[] vis = new boolean[arr.length];
		return solution(arr, start, vis);
	}
	
	public static boolean solution(int[] arr, int start, boolean[] vis) {
		if(arr[start] == 0) {
			return true;
		}
		vis[start] = true;
		boolean res = false;
		if(start - arr[start] >= 0 && start - arr[start]<arr.length && vis[start - arr[start]] == false ) {
			res = solution(arr, start-arr[start], vis);
		}
		if(start + arr[start] >= 0 && start + arr[start] < arr.length && vis[start + arr[start]] == false) {
			res = res || solution(arr, start+arr[start], vis);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,0,2,1,2};
		System.out.println(canReach(arr, 2));
	}
}
