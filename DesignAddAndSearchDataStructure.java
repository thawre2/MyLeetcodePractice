public class DesignAddAndSearchDataStructure {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root;

    public DesignAddAndSearchDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        // assign root to curr node to traverse
        TrieNode curr = root;

        // loop through every character in a word
        for(char c : word.toCharArray()) {
            int index = c - 'a';

            // if children at the index is null the create new node
            if(curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        // base case : reached end of the word
        if(index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        if(c == '.') {
            for(TrieNode child : node.children) {
                if(child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int idx = c - 'a';

            if(node.children[idx] == null) {
                return false;
            }

            return dfs(word, index + 1, node.children[idx]);
        }
    }
}
