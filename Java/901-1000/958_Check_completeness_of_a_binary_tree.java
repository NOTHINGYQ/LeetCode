class Solution {
    //广度优先，按层访问，即使遇到null也要入队，在rednull为true的情况下，访问到非空节点，则一定不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        boolean redNull = false;
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            if(node == null){
                redNull = true;
            }else{
                if(redNull) return false;
                que.add(node.left);
                que.add(node.right);
            }
        }
        return true;
    }
}