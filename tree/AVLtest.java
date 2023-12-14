import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AVLtest {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static int kthSmallest(TreeNode root, int k){
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);

        AVL avl = new AVL(inorderList);

        int[] randomNums = new int[1000];
        Random random = new Random();
        for(int i = 0; i < 1000; i ++){
            randomNums[i] = random.nextInt(10001);
            avl.insert(randomNums[i]);
        }

        shuffle(randomNums);
        for(int i = 0; i < 1000; i ++){
            avl.insert(randomNums[i]);
        }

        return avl.kthSmallest(k);
    }
    public static void inorder(TreeNode node, List<Integer> inorderList){
        if(node == null) return;
        inorder(node.left, inorderList);
        inorderList.add(node.val);
        inorder(node.right, inorderList);
    }

    public static void shuffle(int[] arr){
        Random random = new Random();
        int length = arr.length;
        for(int i = 0; i < length; i ++){
            int randIndex = random.nextInt(length);
            int tmp = arr[i];
            arr[i] = arr[randIndex];
            arr[randIndex] = tmp;
        }
    }
}
