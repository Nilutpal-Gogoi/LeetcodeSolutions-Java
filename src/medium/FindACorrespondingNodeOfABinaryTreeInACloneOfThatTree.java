package medium;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		if(cloned.val == target.val){
        	return cloned;
        }
        
		TreeNode res = null;
        if(original.left != null){
        	res = getTargetCopy(original.left, cloned.left, target);
        	if(res != null) {
        		return res;
        	}
        }
        if(original.right != null) {
        	res = getTargetCopy(original.right, cloned.right, target);
        	if(res != null) {
        		return res;
        	}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		
	}
}
