package medium;

public class ValidateBinarySearchTree {
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
	
	// -------- Approach 1 : Using Max and min ----------------
    public long maxOfBST(TreeNode root){
        if(root == null) return Long.MIN_VALUE;
        
        long max = Long.MIN_VALUE;
        max = Math.max(maxOfBST(root.left), max);
        max = Math.max(maxOfBST(root.right), max);
        
        return Math.max(max, root.val);
    }
    
    public long minOfBST(TreeNode root){
        if(root == null) return Long.MAX_VALUE;
        
        long min = Long.MAX_VALUE;
        min = Math.min(minOfBST(root.left), min);
        min = Math.min(minOfBST(root.right), min);
        
        return Math.min(min, root.val);
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
        long lmax = maxOfBST(root.left);
        long rmin = minOfBST(root.right);
        
        if(lmax >= root.val || rmin <= root.val){
            return false;
        }
        
        return isValidBST(root.left) && isValidBST(root.right);
    }
    
    // ------- Second Approach : Using two pointers ---------
    public boolean isValidBST2(TreeNode root) {
    	TreeNode[] pointers = new TreeNode[2];
    	return validate(root, pointers);
    }
    
    public boolean validate(TreeNode root, TreeNode[] pointers) {
    	if(root == null) return true;
    	boolean res = true;
    	res = validate(root.left, pointers);
    	if(res == false) {
    		return false;
    	}
    	if(pointers[0] == null) {
    		pointers[0] = root;
    	}else {
    		pointers[1] = root;
    		if(pointers[0].val >= pointers[1].val) {
    			return false;
    		}
    		pointers[0] = root;
    	}
    	
    	res = validate(root.right, pointers);
    	return res;
    }
}
