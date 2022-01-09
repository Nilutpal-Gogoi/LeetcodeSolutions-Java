package easy;

public class MaximumNumberOfWordsFoundInSentences {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        
        for(int i = 0; i<sentences.length; i++){
            String[] str = sentences[i].split(" ");
            if(str.length > res){
                res = str.length;
            }
        }
        
        return res;
    }
}
