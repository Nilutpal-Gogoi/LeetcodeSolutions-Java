package medium;

public class InsertIntoABinarySearchTree {
	
	class TreeNode{
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
	
	public TreeNode insertIntoBST(TreeNode root, int val) {
		TreeNode nn = new TreeNode(val);
		if(root == null){
            root = nn;
            return root;
        }
        helper(root, nn);
		return root;
	}
	
	public void helper(TreeNode root, TreeNode nn) {
		if(nn.val < root.val) {
			if(root.left == null) {
				root.left = nn;
			}else {
				helper(root.left, nn);				
			}
		} else if(nn.val> root.val) {
			if(root.right == null) {
				root.right = nn;
			}else {
				helper(root.right, nn);
			}
		}
	}
}
