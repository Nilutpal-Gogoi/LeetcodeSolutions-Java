package medium;

public class ConstructBSTFromPreOrderTraversal {
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
	
	static int indx = 0;
	
	public TreeNode bstFromPreorder(int[] pre, int leftRange, int rightRange) {
		if(indx >= pre.length || pre[indx] < leftRange || rightRange < pre[indx]) {
			return null;
		}
		
		int val = pre[indx];
		TreeNode root = new TreeNode(val);
		indx++;
		
		root.left = bstFromPreorder(pre, leftRange, val);
		root.right = bstFromPreorder(pre, val, rightRange);
		return root;
		
	}
	
    public TreeNode bstFromPreorder(int[] preorder) {
        indx = 0;
        return bstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
