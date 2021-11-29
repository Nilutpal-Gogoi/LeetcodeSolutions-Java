package medium;

import java.util.*;

public class MaximumWidthOfBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	private class WPair{
		TreeNode node;
		int indx;
		
		public WPair(TreeNode node, int indx) {
			this.node = node;
			this.indx = indx;
		}
	}
	
	public int widthOFBinaryTree(TreeNode root) {
		Queue<WPair> qu = new LinkedList<>();
		qu.add(new WPair(root, 0));
		
		int maxWidth = 0;
		
		while(qu.size() > 0) {
			int size = qu.size();
			int lm = qu.peek().indx;     // left most index
			int rm = qu.peek().indx;     // right most index
			while(size-- > 0) {
				// 1. get + remove
				WPair rem = qu.remove();
				
				// 2. work
				rm = rem.indx;
				
				// 3. add children with index
				if(rem.node.left != null) {
					qu.add(new WPair(rem.node.left, 2*rem.indx+1));
				}
				if(rem.node.right != null) {
					qu.add(new WPair(rem.node.right, 2*rem.indx + 2));
				}
			}
			// width of current level
			int width = rm-lm+1;
			// maximize 
			maxWidth = Math.max(maxWidth, width);
		}
		return maxWidth;	
	}
}
