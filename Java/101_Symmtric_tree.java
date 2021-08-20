class Solution {
    //对称二叉树，考虑树的排列特点
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return compare(root.left, root.right);
    }
    private boolean compare(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        else if(left != null && right == null) return false;
        else if(left == null && right != null) return false;
        else if(left.val != right.val) return false;

        return compare(left.right, right.left) && compare(left.left, right.right);
    }
}