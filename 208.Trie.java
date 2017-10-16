class TrieNode {
    private boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {
        
    }
    public void setWord(boolean isWord) {
        this.isWord = isWord;
    }
    public boolean getWord() {
        return this.isWord;
    }
}

public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if(temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.setWord(true);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if(temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        return temp.getWord();
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if(temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        return true;
    }
}