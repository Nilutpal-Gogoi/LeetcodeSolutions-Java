package easy;

public class ReverseVowelsOfString {
	
	private boolean isVowel(char ch) {
		if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
			return true;
		} else if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U') {
			return true;
		}
		return false;
	}
	
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        
        int left = 0;
        int right = arr.length-1;
        
        while(left < right) {
        	// make left pointer at vowel
        	while(left < right && isVowel(arr[left]) == false) {
        		left++;
        	}
        	
        	// make right pointer at vowel
        	while(left < right && isVowel(arr[right]) == false) {
        		right--;
        	}
        	
        	char temp = arr[left];
        	arr[left] = arr[right];
        	arr[right] = temp;
        	
        	left++;
        	right--;
        }
        
        return String.valueOf(arr);
    }
}
