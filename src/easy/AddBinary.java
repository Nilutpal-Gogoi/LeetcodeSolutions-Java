package easy;

public class AddBinary {
    public static String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder str = new StringBuilder();
        char car = '0';
        while(i >= 0 || j >= 0){
            char chA = i >= 0 ? a.charAt(i) : '0';
            char chB = j >= 0 ? b.charAt(j) : '0';
            if(chA == '1' && chB == '1'){
                if(car == '0'){
                    str.append('0');
                    car = '1';
                }else{
                    str.append('1');
                    car = '1';
                }
            }else if((chA == '1' && chB == '0') || (chA == '0' && chB == '1')){
                if(car == '0'){
                    str.append('1');
                }else{
                    str.append('0');
                    car = '1';
                }
            }else if(chA == '0' && chB == '0'){
                if(car == '0'){
                    str.append('0');
                }else{
                    str.append('1');
                    car = '0';
                }
            }
            i--;
            j--;
        }
        
        if(car == '1') {
        	str.append('1');
        }
        
        String res = str.reverse().toString();
        return res;
    }
    
    public static void main(String[] args) {
    	String res = addBinary("1010", "1011");
    	System.out.println(res);
    }
}
