/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
*/

class WordDictionary {
    private final int ALPHABET_SIZE = 26;
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        
        TrieNode(){
            children = new TrieNode[ALPHABET_SIZE];
            for(int i = 0; i<children.length;i++){
                children[i] = null;
                isEnd = false;
            }
        }
    }
    
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        int index = 0;
        TrieNode crawl = root;
        for(int i = 0; i< word.length(); i++){
            index = word.charAt(i)-'a';
            if(crawl.children[index]==null)
                crawl.children[index] = new TrieNode();
            crawl = crawl.children[index];
        }
        crawl.isEnd = true;
    }
    
    public boolean search(String word) {
        // call dfs helper function to search for word
        return DFS(word, root, 0);
    }
    
    public boolean DFS(String word, TrieNode current, int index){
        // base case, terminate DFS when you've built a word
        if(index == word.length()){
            return current.isEnd;
        }
        // character from word to process
        char c = word.charAt(index);
        // check if the character is a .
        if(c == '.'){
            // if it is find that character amongst all letters
            for(int i = 0; i< ALPHABET_SIZE; i++){
                // check if any letter is in the tree and go to its child to build word
                if(current.children[i] != null && DFS(word, current.children[i],index+1)){
                    // if the dfs reaches end of word and returns true
                    // we have found the word
                   return true;
                }
            }
            // if the dfs reaches end of word and is false we didnt find word
            return false;
        }
        // if there's no '.' traverse tree recursively using DFS function
        // if the letter is in the tree, process its children
        else return (current.children[word.charAt(index)-'a']!=null && DFS(word,current.children[word.charAt(index)-'a'],index+1));

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */