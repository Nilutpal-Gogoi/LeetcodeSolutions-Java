// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
package easy;

public class CheckIfTwoStringArraysAreEquivalent {
    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1, word2));
    }
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2){
        StringBuffer st1 = new StringBuffer();
        StringBuffer st2 = new StringBuffer();
        for (String value : word1) {
            st1.append(value);
        }
        for (String s : word2) {
            st2.append(s);
        }
        return st1.toString().equals(st2.toString());
    }
}
