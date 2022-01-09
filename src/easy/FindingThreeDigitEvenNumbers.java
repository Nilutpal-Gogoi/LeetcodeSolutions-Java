package easy;

import java.util.*;

public class FindingThreeDigitEvenNumbers {
    public static int[] findEvenNumbers(int[] digits) {
    	ArrayList<Integer> res =new ArrayList<>();
    	int[] freq = new int[10];
    	for(int i : digits) {
    		freq[i]++;
    	}
    	
    	for(int i=100; i<=998; i+=2) {
    		if(check(i, freq) == true) {
    			res.add(i);
    		}
    	}
    	int[] rres = new int[res.size()];
    	for(int i=0; i<rres.length; i++) {
    		rres[i] = res.get(i);
    	}
    	return rres;
    }
    
    private static boolean check(int n, int[] freq) {
    	int[] freq2 = new int[10];
    	while(n != 0) {
    		freq2[n%10] += 1;
    		n /= 10;
    	}
    	for(int i = 0; i<10; i++) {
    		if(freq2[i] != 0 && freq2[i] > freq[i]) return false;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	int[] digits = {2,3,1,0};
    	int[] res = findEvenNumbers(digits);
    	for(int i = 0 ; i<res.length; i++) {
    		System.out.println(res[i]);
    	}
    }
}
