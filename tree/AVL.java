import java.util.List;

public class AVL {
    Node root;
    class Node{
        int val;
        Node parent;
        Node left;
        Node right;
        int size;
        int height;
        public Node(int val){
            this(val, null);
        }
        public Node(int val, Node parent){
            this(val, parent, null, null);
        }
        public Node(int val, Node parent, Node left, Node right){
            this.val = val;
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.height = 0; //the height of subtree with the node as root (the height of leaf node is 0)
            this.size = -1; //the total number of nodes of subtree with node as root
        }
    }
    public AVL(List<Integer> vals){
        if(vals != null){
            this.root = build(vals, 0, vals.size() - 1, null);
        }
    }
    private Node build(List<Integer> vals, int l, int r, Node parent){
        int m = (l + r) >> 1;
        Node node = new Node(vals.get(m), parent);
        if(l <= m - 1){
            node.left = build(vals, l, m - 1, node);
        }
        if(m + 1 <= r){
            node.left = build(vals, l, m - 1, node);
        }
        recompute(node);
        return node;
    }
    public int kthSmallest(int k){
        Node node = root;
        while(node != null){
            int left = getSize(node.left);
            if(left < k - 1){
                node = node.right;
                k -= left + 1;
            }else if(left == k - 1){
                break;
            }else {
                node = node.left;
            }
        }
        return node.val;
    }

    public void insert(int v){
        if(root == null){
            root = new Node(v);
        }else{
            Node node = subtreeSearch(root, v);
            boolean isAddLeft = v <= node.val; //whether add new node to left subtree
            if(node.val == v){ //if node v exist
                if(node.left != null){//if node v exist in left subtree, add to the right most of left subtree
                    node = subtreeLast(node.left);
                    isAddLeft = false;
                }else {//node v not exist, add to left
                    isAddLeft = true;
                }
            }
            //add new node
            Node leaf = new Node(v, node);
            if(isAddLeft){
                node.left = leaf;
            }else{
                node.right = leaf;
            }
            rebalance(leaf);
        }
    }

    //delete node with val as v
    public boolean delete(int v){
        if(root == null){
            return false;
        }
        Node node = subtreeSearch(root, v);
        if(node.val != v){//not find the node
            return false;
        }
        if(node.left != null && node.right != null){
            Node replacement = null;
            if(node.left.height <= node.right.height){
                replacement = subtreeFirst(node.right);
            }else{
                replacement = subtreeLast(node.left);
            }
            node.val = replacement.val;
            node = replacement;
        }
        Node parent = node.parent;
        delete(node);
        rebalance(parent);
        return true;
    }

    private void delete(Node node){
        if(node.left != null && node.right != null){
            return;
        }
        Node child = node.left != null ? node.left:node.right;
        if(child != null){
            child.parent = node.parent;
        }
        if(node == root){
            root = child;
        }else{
            Node parent = node.parent;
            if(node == parent.left){
                parent.left = child;
            }else{
                parent.right = child;
            }
        }
        node.parent = node;
    }

    private Node subtreeSearch(Node node, int v){
        if(node.val < v && node.right != null){
            return subtreeSearch(node.right, v);
        }else if(node.val > v && node.left != null){
            return subtreeSearch(node.left, v);
        }else{
            return node;
        }
    }

    private void recompute(Node node){
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        node.size = 1 + getSize(node.left) + getSize(node.right);
    }

    private void rebalance(Node node){
        while(node != null){
            int oldHeight = node.height, oldSize = node.size;
            if(!isBalanced(node)){
                node = restructure(tallGrandchild(node));
                recompute(node.left);
                recompute(node.right);
            }
            recompute(node);
            if(node.height == oldHeight && node.size == oldSize){
                node = null;
            }else{
                node = node.parent;
            }
        }
    }

    private boolean isBalanced(Node node){
        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1;
    }

    private Node tallChild(Node node){
        if(getHeight(node.left) > getHeight(node.right)){
            return node.left;
        }else{
            return node.right;
        }
    }

    private Node tallGrandchild(Node node){
        Node child = tallChild(node);
        return tallChild(child);
    }

    private static void relink(Node parent, Node child, boolean isLeft){
        if(isLeft){
            parent.left = child;
        }else{
            parent.right = child;
        }
        if (child != null) {
            child.parent = parent;
        }
    }

    private void rotate(Node node){
        Node parent = node.parent;
        Node grandparent = parent.parent;
        if(grandparent == null){
            root = node;
            node.parent = null;
        }else{
            relink(grandparent, node, parent == grandparent.left);
        }

        if(node == parent.left){
            relink(parent, node.right, true);
            relink(node, parent, false);
        }
        else{
            relink(parent, node.left, false);
            relink(node, parent, true);
        }
    }

    private Node restructure(Node node){
        Node parent = node.parent;
        Node grandparent = parent.parent;
        if((node == parent.right) == (parent == grandparent.right)){
            rotate(parent);
            return  parent;
        }
        else{
            rotate(node);
            rotate(node);
            return node;
        }
    }

    private static Node subtreeFirst(Node node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    private static Node subtreeLast(Node node){
        while(node.right != null){
            node = node.right;
        }
        return node;
    }

    private static int getHeight(Node node){
        return node != null ? node.height : 0;
    }

    private static int getSize(Node node){
        return node != null ? node.size : 0;
    }
}
