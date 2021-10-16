/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
*/

class Trie {
    // define alphabet size
    private final int ALPHABET_SIZE = 26;
    
    // define new class TrieNode
    class TrieNode{
        // instance variables
        TrieNode[] children;
        boolean isEnd;

        // constructor to initialize each trienode
        public TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
            for(int i = 0; i < ALPHABET_SIZE; i++){
                children[i] = null;
            }
            isEnd = false;
        }
    }
    
    // instance variable root
    TrieNode root;
    
    // initialize root in constructor
    public Trie(){
        root = new TrieNode();
    }
    
    // string insert function
    public void insert(String word) {
        // get index of word's character in our tree
        int index = 0;
        // variable to traverse our tree
        TrieNode crawl = root;
        // iterate over word
        for(int i = 0; i < word.length(); i++){
            // get index of word's character in our tree
            index = word.charAt(i) - 'a';
            // if the character is not in our tree, add it
            if(crawl.children[index] == null){
                crawl.children[index] = new TrieNode();
            }
            // go to the child of the character in the tree
            crawl = crawl.children[index];
        }
        // mark end of the word as true
        crawl.isEnd = true;
    }
    
    // function to search for word
    public boolean search(String word) {
        // get index of word's character in tree
        int index = 0;
        // variable to traverse the tree
        TrieNode crawl = root;
        // traverse the word
        for(int i = 0; i < word.length(); i++){
            // get index of words character in our tree
            index = word.charAt(i) - 'a';
            // check if the letter exists in our tree
            if(crawl.children[index] == null)
                return false;
            // move on to letters child
            crawl = crawl.children[index];
        }
        // return if the word is found or not
        return crawl.isEnd;
    }
    
    // same as search
    public boolean startsWith(String prefix) {
        int index = 0;
        TrieNode crawl = root;
        for(int i = 0; i < prefix.length(); i++){
            index = prefix.charAt(i) - 'a';
            if(crawl.children[index] == null)
                return false;
            crawl = crawl.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */