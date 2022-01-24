package medium;

import medium.LinkedListCycleII.ListNode;

public class ConvertSortedListToBinarySearchTree {
	
	public static class ListNode{
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        return helper(head, null);
    }
    
    public TreeNode helper(ListNode start, ListNode end){
        ListNode slow = start;
        ListNode fast = start;
        if(start == end){
            return null;
        }
        while(fast != end && fast.next != end){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(start, slow);
        root.right = helper(slow.next, end);
        
        return root;
    }
}
