package easy;

import java.util.*;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        if(s.length() == 0){
            return t.charAt(0);
        }
        char[] arr1 = new char[s.length()];
        for(int i=0; i<s.length(); i++) {
        	arr1[i] = s.charAt(i);
        }
        Arrays.sort(arr1);
        
        char[] arr2 = new char[t.length()];
        for(int i=0; i<t.length(); i++) {
        	arr2[i] = t.charAt(i);
        }
        
        Arrays.sort(arr2);
        
        int i = 0;
        int j = 0;
        char res = '1';
        while(i < s.length()) {
        	if(arr1[i] != arr2[j]) {
        		res = arr2[j];
                break;
        	}
        	i++;
        	j++;
        }
        
        if(i == s.length()) {
        	res = arr2[j];
        }
        
        return res;
    }
    
    // method - 2 ( Ascii sum)
    public char findTheDiff2(String s, String t) {
        int x = 0;
        for(int i =0; i<s.length(); i++){
            x += s.charAt(i)-'a';
        }
        int y = 0;
        for(int i=0; i<t.length(); i++){
            y += t.charAt(i)-'a';
        }
        return (char) (y-x+'a');
    }
}
