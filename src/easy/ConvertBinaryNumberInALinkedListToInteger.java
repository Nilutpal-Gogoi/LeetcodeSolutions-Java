package easy;

public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int mFactor = 1;
        int res = 0;
        StringBuilder st = new StringBuilder();
        ListNode temp = head;
        while(temp!= null){
            st.append(temp.val);
            temp = temp.next;
        }
        
        for(int i = st.length()-1; i>=0; i--){
            int ele = st.charAt(i)-'0';
            res += (ele*mFactor);
            mFactor *= 2;
        }
        return res;
    }
    
    public int getDecimalValue2(ListNode head) {
        int mFactor = 2;
        int res = 0;
        ListNode temp = head;
        while(temp!= null){
            res = (mFactor*res)+temp.val;
            temp = temp.next;
        }
        
        return res;
    }
}
