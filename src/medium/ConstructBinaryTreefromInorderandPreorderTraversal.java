package medium;

public class ConstructBinaryTreefromInorderandPreorderTraversal {
	 public class TreeNode {
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
 
 private TreeNode constructPreIn(int[] pre, int[] in, int preSt, int preEnd, int inSt, int inEnd) {
	 if(preSt > preEnd) return null;
//	 if(preSt == preEnd) {
//		 return new TreeNode(pre[preSt]);
//	 }
	 
	 
	 TreeNode root = new TreeNode(pre[preSt]);
	 
	 // find presence of root node in inorder with index indx
	 int indx = inSt;
	 while(in[indx] != pre[preSt]) {
		 indx++;
	 }
	 
	 int elementCount = indx - inSt;
	 root.left = constructPreIn(pre, in, preSt+1, preSt + elementCount, inSt, indx - 1);
	 root.right = constructPreIn(pre, in, preSt + elementCount + 1, preEnd, indx + 1, inEnd);
	 
	 return root;
 }
 
 public TreeNode buildTree(int[] preorder, int[] inorder) {
	 if(preorder.length == 0) return null;
	 return constructPreIn(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
 }
}
