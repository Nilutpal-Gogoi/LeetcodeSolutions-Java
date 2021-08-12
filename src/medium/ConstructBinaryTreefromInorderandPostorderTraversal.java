package medium;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
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
	 
	private TreeNode constructPostIn(int[] post, int[] in, int poSt, int poEnd, int inSt, int inEnd) {
		 if(poSt > poEnd) return null;
		 TreeNode root = new TreeNode(post[poEnd]);
		 
		 int indx = inSt;
		 while(in[indx] != post[poEnd])
			 indx++;
		 
		 int elementCount = indx - inSt;
		 
		 root.left = constructPostIn(post, in, poSt, poSt + elementCount - 1, inSt, indx - 1);
		 root.right = constructPostIn(post, in, poSt+elementCount, poEnd-1, indx+1, inEnd);
		
		 return root;
	 }
	 
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
		 if(postorder.length == 0) return null;
		 return constructPostIn(postorder, inorder, 0, postorder.length-1, 0, inorder.length-1);
	 }
}
