package easy;

public class PalindromeOfLinkedList {
	public static class ListNode{
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
		
	  public ListNode middleNode(ListNode head) {
	      if(head == null) return null;
	      
	      ListNode p1 = head;
	      ListNode p2 = head.next;
	      
	      while(p2 != null && p2.next != null){
	          p1 = p1.next;
	          p2 = p2.next.next;
	      }
	      return p1;
	  }
		
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
		
	   public boolean isPalindrome(ListNode head) {
		   	if(head == null) return false;
		   	boolean isPalindrome = true;
		       // step 1: find middle 1
		   	ListNode mid = middleNode(head);
		   	
		   	// step 2: reverse second half of linkedlist
		   	ListNode head2 = mid.next;
		   	head2 = reverseList(head2);
		   	
		   	// step 3: check if data is equal or not
		   	ListNode temp1 = head, temp2 = head2;
		   	while(temp1 != null && temp2 != null) {
		   		if(temp1.val != temp2.val) {
		   			isPalindrome = false;
		   			break;
		   		}
	            temp1 = temp1.next;
	            temp2 = temp2.next;
		   	}
		   	
		   	// step 4: preserve
		   	head2 = reverseList(head2);
		   	mid.next = head2;
		   	
		   	return isPalindrome;
	   }
}
