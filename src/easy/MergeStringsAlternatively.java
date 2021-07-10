package easy;

public class MergeStringsAlternatively {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2));
    }
    public static String mergeAlternately(String word1, String word2){
        StringBuffer res = new StringBuffer();
        if(word1.length() > word2.length()){
            int i = 0;
            while(i<word2.length()){
                res.append(word1.charAt(i));
                res.append(word2.charAt(i));
                i++;
            }
            while(i<word1.length()){
                res.append(word1.charAt(i));
                i++;
            }
        }
        else if(word1.length()< word2.length()){
            int i = 0;
            while(i<word1.length()){
                res.append(word1.charAt(i));
                res.append(word2.charAt(i));
                i++;
            }
            while(i<word2.length()){
                res.append(word2.charAt(i));
                i++;
            }
        }
        else{
            int i = 0;
            while(i<word2.length()){
                res.append(word1.charAt(i));
                res.append(word2.charAt(i));
                i++;
            }
        }
        return res.toString();
    }
}
