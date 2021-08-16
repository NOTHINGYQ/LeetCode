class Solution {
    //利用递归，先判断只有根节点为空情况，然后判断两个分支的差值是否为1，最后返回左右孩子是否也满足情况
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        int diff = Math.abs(left - right);
        return diff <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    private int getHeight(TreeNode root){
        if(root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
