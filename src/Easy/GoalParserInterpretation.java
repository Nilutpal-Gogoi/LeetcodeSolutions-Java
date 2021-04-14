// https://leetcode.com/problems/goal-parser-interpretation/
package Easy;

public class GoalParserInterpretation {
    public static void main(String[] args) {
        String command = "(al)G(al)()()G";
        System.out.println(interpret(command));
    }
    public static String interpret(String command){
        StringBuffer str = new StringBuffer();
        for(int i=0;i<command.length();i++){
            if(command.charAt(i) == 'G'){
                str.append("G");
            }
            else if(command.charAt(i) == '('){
                if(command.charAt(i+1) == ')'){
                    str.append("o");
                }
                else{
                    str.append("al");
                }
            }
        }
        return str.toString();
    }
}
