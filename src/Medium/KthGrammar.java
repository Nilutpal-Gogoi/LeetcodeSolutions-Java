// https://leetcode.com/problems/k-th-symbol-in-grammar/submissions/
package Medium;

public class KthGrammar {
    public static void main(String[] args) {
        System.out.println(kthGrammar(4,5));
    }
    public static int kthGrammar(int N, int K){
        if(N==1 && K == 1)
            return 0;
        int mid = (int) ((Math.pow(2,N-1))/2);
        if(K <= mid)
            return kthGrammar(N-1, K);
        else{
            int x = kthGrammar(N-1, K-mid);
            return x == 0?1:0;
        }
    }
}
