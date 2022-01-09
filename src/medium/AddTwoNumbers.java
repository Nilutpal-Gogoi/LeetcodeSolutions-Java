package medium;

public class AddTwoNumbers{
	class ListNode{
		int val;
		ListNode next;
		
		ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1  = l1;
        ListNode head2 = l2;
        
        ListNode nn = new ListNode(-1);
        ListNode head = nn;
        
        int carry = 0;
        while(head1 != null || head2 != null || carry != 0){
            int val1 = head1 == null?0:head1.val;
            int val2 = head2 == null?0:head2.val;
            
            int val = (val1+val2+carry) > 9 ? (val1+val2+carry)%10 : (val1+val2+carry);
            carry = (val1+val2+carry)/10;
            ListNode n1 = new ListNode(val);
            nn.next = n1;
            nn = n1;
            head1 = head1 == null? head1 : head1.next;
            head2 = head2 == null ? head2 : head2.next;
        }
        
        return head.next;
    }
}
