public class Trie {
    TrieNode root;
    class TrieNode{
        public TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i ++){
            char ch = word.charAt(i);
            if(node.children[ch - 'a'] == null){
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch -'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i ++){
            char ch = word.charAt(i);
            if(node.children[ch - 'a'] == null) return false;
            node = node.children[ch -'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i ++){
            char ch = prefix.charAt(i);
            if(node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
        }
        return true;
    }
}