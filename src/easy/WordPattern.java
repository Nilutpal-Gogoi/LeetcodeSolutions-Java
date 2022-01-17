package easy;

import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        for(int i =0 ; i< pattern.length(); i++){
            char ch = pattern.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, arr[i]);
            }
            if(!map2.containsKey(arr[i])){
                map2.put(arr[i], ch);
            }
        }
        for(int i = 0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            String str = arr[i];
            if(!map.get(ch).equals(str)){
                return false;
            }
            if(!map2.get(arr[i]).equals(ch)){
                return false;
            }
        }
        return true;
    }
}
