package easy;

public class RemoveDuplicatesFromSortedList {
	
	
	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode temp = head;
        ListNode itr = temp.next;
        
        while(itr != null){
            if(itr.val == temp.val){
                itr = itr.next;
            } else {
                temp.next = itr;
                temp = temp.next;
                itr = itr.next;
            }
        }
        
        temp.next = itr;
        return head;
    }
}
