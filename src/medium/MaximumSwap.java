package medium;

public class MaximumSwap {
	public int maximumSwap(int n) {
		String num = n + "";
		// convert number int o string
		char[] arr = num.toCharArray();
		
		int[] lastIndxOfDigit = new int[10];
		// traverl and fill last index of digits
		for(int i=0; i<arr.length; i++) {
			lastIndxOfDigit[arr[i]- '0'] = i;
		}
		
		// travel and find swapping point
		for(int i = 0; i < arr.length; i++) {
			int digit = arr[i] - '0';
			int indx = i;
			for(int j = 9; j > digit; j--) {
				if(lastIndxOfDigit[j] > i) {
					indx = lastIndxOfDigit[j];
					break;
				}
			}
			if(indx != i) {
				swap(arr, i, indx);
				break;
			}
		}
		String res = String.valueOf(arr);
		
		// convert string into number
		return Integer.parseInt(res);
	}
	
	private void swap(char[] arr, int left, int right) {
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
