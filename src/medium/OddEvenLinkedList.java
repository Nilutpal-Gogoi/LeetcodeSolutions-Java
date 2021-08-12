package medium;

public class OddEvenLinkedList {
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public ListNode oddEvenList(ListNode head) {
		ListNode ohead = new ListNode(-1);
		ListNode ehead = new ListNode(-1);
		
		ListNode temp = head, t1 = ohead, t2 = ehead;
		
        int i = 1;
		while(temp != null) {
			if(i%2 == 0) {
				t2.next = temp;
				t2 = temp;
			} else {
				t1.next = temp;
				t1 = temp;
			}
			temp = temp.next;
            i++;
		}
		t1.next = null;
		t2.next = null;
		
		// add lists accordingly
		t1.next = ehead.next;
		return ohead.next;
	}
}
