package medium;

import java.util.*;

public class AllElementsInTwoBinarySearchTrees {
	
	// ------ Basic Approach -----------------
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        solution(root1, root2, list);
        list.sort(null);
        return list;
    }
    
    public void solution(TreeNode root1, TreeNode root2, List<Integer> list) {
    	if(root1 == null && root2 == null) {
    		return;
    	}else if(root1 == null) {
    		list.add(root2.val);
    		solution(root1, root2.left, list);
    		solution(root1, root2.right, list);
    	}else if(root2 == null) {
    		list.add(root1.val);
    		solution(root1.left, root2, list);
    		solution(root1.right, root2, list);
    	}else {
    		list.add(root1.val, root2.val);
    		solution(root1.left, root2.left, list);
    		solution(root1.right, root2.right, list);
    	}
    }
    
    // ------- Optimized Approach : Using Stacks ------------------
    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2){
    	List<Integer> list = new ArrayList<>();
    	Stack<TreeNode> st1 = new Stack<>();
    	Stack<TreeNode> st2 = new Stack<>();

    	// we will put all the elements in our stack until reach the leaf node
        // of both the root1 & root2 tree. First left, then right
    	while(!st1.isEmpty() || !st2.isEmpty() || root1 != null || root2 != null) {
            // filling our stack with all left values of root1 tree
    		while(root1 != null) {
    			st1.push(root1);
    			root1 = root1.left;
    		}
    		// filling our stack with all left values of root2 tree
    		while(root2 != null) {
    			st2.push(root2);
    			root2 = root2.left;
    		}
    		
    		// either stack2 is empty we will pop all vaues from stack1 straight away but,
            // if stack2 is not empty then we will get their peek values
            // of both the stack1 & stack2 and compare them
            // if stack1 value is less then, add it into our result & move to right

    		if(st2.isEmpty() || (!st1.isEmpty() && st1.peek().val <= st2.peek().val)){
    			root1 = st1.pop();
    			list.add(root1.val);
    			root1 = root1.right;
    		}
    		// either stack1 is empty we will pop all values from stack2 straight away but,
            // if stack1 is not empty then we will get their peek values
            // of both the stack1 & stack2 and compare them
            // if stack2 value is less then, add it into our result & move to right
    		else {
    			root2 = st2.pop();
    			list.add(root2.val);
    			root2 = root2.right;
    		}
    	}
    	
    	return list;
    }
}
