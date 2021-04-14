// https://leetcode.com/problems/defanging-an-ip-address/

package Easy;

public class DefangingAnIPAddress {
    public static void main(String[] args) {
        String address = "255.100.50.0";
        System.out.println(defangIPaddr(address));
    }
    public static String defangIPaddr(String address){
        StringBuffer res = new StringBuffer();
        for(int i=0;i<address.length();i++){
            if(address.charAt(i) != '.'){
                res.append(address.charAt(i));
            }
            else{
                res.append("[.]");
            }
        }
        return res.toString();
    }
}
