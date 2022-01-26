package medium;

import java.util.*;

public class AllElementsInTwoBinarySearchTrees {
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
}
