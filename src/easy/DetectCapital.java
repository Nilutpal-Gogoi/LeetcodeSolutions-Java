package easy;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        boolean flag = true;
        int upCount = 0;
        int lowCount = 0;
        if(word.charAt(0) < 'A' || word.charAt(0) > 'Z'){
            flag = false;
            lowCount++;
        }else{
            flag = true;
            upCount++;
        }
        for(int i = 1 ; i<word.length(); i++){
            char ch = word.charAt(i);
            if(ch < 'A' || ch > 'Z'){
                lowCount++;
            }else{
                upCount++;
            }
        }
        
        
        if(lowCount == word.length() || upCount == word.length() || (flag && upCount == 1 && lowCount == word.length()-1)){
            return true;
        }else{
            return false;
        }
    }
}
