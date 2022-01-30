package medium;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String str) {
		int ansLen = 0;
		int acq = -1;
		int rel = -1;
		
		HashMap<Character, Integer> map = new HashMap<>();
		while(true) {
			boolean acflag = false;
			boolean reflag = false;
			
			// acquire 
			while(acq < str.length() - 1) {
				acflag = true;
				acq++;
				char ch = str.charAt(acq);
				map.put(ch,  map.getOrDefault(ch, 0)+1);
				
				if(map.get(ch) == 2) {
					// stop acq
					break;
				}else {
					int tempLen = acq - rel;
					if(tempLen > ansLen) ansLen = tempLen;
				}
			}
			
			// release
			while(rel < acq) {
				reflag = true;
				rel++;
				char ch = str.charAt(rel);
				map.put(ch,  map.get(ch)-1);
				if(map.get(ch) == 1) {
					// after reducing, if freq is , that means this ch character is responsible for repitition
					break;
				}
			}
			
			if(acflag == false && reflag == false)break;
			
		}
		
		return ansLen;
    }
}
