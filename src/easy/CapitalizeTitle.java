//package easy;
//
//public class CapitalizeTitle {
//    public String capitalizeTitle(String title) {
//        boolean flag = false;
//        String res= "";
//        for(int i = 0; i<title.length(); i++){
//            char ch = title.charAt(i);
//        	if(flag == false){
//                if(ch > 'a' && ch < 'z') {
//                	String s = ch+"";
//                	String r = s.toUpperCase();
//                	res += r;
//                }else {
//                	res += ch;
//                }
//            }else {
//            	if(ch > 'A' && ch < 'Z') {
//            		String s = ch+"";
//                	String r = s.toLowerCase();
//                	res += r;
//            	}else {
//            		res += ch;
//            	}
//            }
//        	
//        	if(ch == ' ') {
//        		flag = false;
//        	}else {
//        		flag = true;
//        	}
//        }
//        
//        return res;
//    }
//}
