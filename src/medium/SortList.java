package medium;

public class SortList {
	public static class ListNode{
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public ListNode middleNode1(ListNode head) {
        if(head == null) return null;
        
        ListNode p1 = head;
        ListNode p2 = head;
        
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
    
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		ListNode head = new ListNode(-1);
		ListNode dummy = head;
		
		while(temp1 != null && temp2 != null) {
			if(temp1.val <= temp2.val) {
				dummy.next = temp1.next;
			} else {
				dummy.next = temp2.next;
			}
		}
		
		if(temp1 == null) {
			dummy.next = temp2;
		} else {
			dummy.next = temp1;
		}
		
		return head.next;
	}
	
    public ListNode sortList(ListNode head1) {
    	 if(head1 == null || head1.next == null) return head1;
    	
    	 ListNode mid = middleNode1(head1);
    	 ListNode head2 = mid.next;
    	 mid.next = null;
    	 
    	 head1 = sortList(head1);
    	 head2 = sortList(head2);
    	 ListNode res = mergeTwoLists(head1, head2);
    	 
    	 return res;
    }
}
