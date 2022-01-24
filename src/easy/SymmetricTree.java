package easy;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        boolean res = isSame(root.left, root.right);
        return res;
    }
    
    public boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }else if(p != null && q == null){
            return false;
        }else if(p == null && q != null){
            return false;
        }
        
        if(p.val != q.val){
            return false;
        }
        boolean res = true;
        res = isSame(p.left, q.right);
        if(res == false){
            return false;
        }
        res = isSame(p.right, q.left);
        return res;
    }
}
