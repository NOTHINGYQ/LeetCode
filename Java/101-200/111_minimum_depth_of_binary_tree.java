class Solution {
    //dfs
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        int min = Integer.MAX_VALUE;
        if(root.left != null){
            min = Math.min(minDepth(root.left), min);
        }
        if(root.right != null){
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }
    
    //bfs
    public int minDepth(TreeNode root){
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        int flag = 0;
        while(queue.peek() != null){
            int size = queue.size();
            depth++;
            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                if(node.left == null && node.right == null){
                    flag = 1;
                    break;
                }
            }
            if(flag == 1) break;
        }
        return depth;
    }

}