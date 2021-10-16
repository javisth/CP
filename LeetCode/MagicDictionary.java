/*
Design a data structure that is initialized with a list of different words. Provided a string, you should determine if you can change exactly one character in this string to match any word in the data structure.

Implement the MagicDictionary class:

MagicDictionary() Initializes the object.
void buildDict(String[] dictionary) Sets the data structure with an array of distinct strings dictionary.
bool search(String searchWord) Returns true if you can change exactly one character in searchWord to match any string in the data structure, otherwise returns false.
 

Example 1:

Input
["MagicDictionary", "buildDict", "search", "search", "search", "search"]
[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
Output
[null, null, false, true, false, false]

Explanation
MagicDictionary magicDictionary = new MagicDictionary();
magicDictionary.buildDict(["hello", "leetcode"]);
magicDictionary.search("hello"); // return False
magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to match "hello" so we return True
magicDictionary.search("hell"); // return False
magicDictionary.search("leetcoded"); // return False
*/


class MagicDictionary {
    // intitialize alphabet size as a constant
    private final int ALPHABET_SIZE = 26;
    
    // make a class for trie node type
    class TrieNode{
        // instance variables
        TrieNode[] children;
        boolean isEnd;
        
        // initialize constructor
        TrieNode(){
            children = new TrieNode[ALPHABET_SIZE];
            for(int i = 0; i< ALPHABET_SIZE; i++){
                children[i] = null;
            }
            isEnd = false;
        }
    }
    
    TrieNode root;
    
    // function to insert a word in te trie
    public void insert(String word){
        // variable to store index of words letter in tree
        int index = 0;
        // variable to crawl the tree
        TrieNode crawl = root;
        // traverse the word to insert
        for(int i = 0; i< word.length(); i++){
            // retrieve index of word in tree
            index = word.charAt(i) - 'a';
            // if a letter is not in tree, insert it
            if(crawl.children[index]==null)
                crawl.children[index] = new TrieNode();
            // move on to the child of the current letter
            crawl = crawl.children[index];
        }
        // set the last letter to be the end
        crawl.isEnd = true;
    }
    
    // similar to traditional search, checks if a word is in the trie
    public boolean contains(char[] word){
        TrieNode crawl = root;
        int index = 0;
        for(int i = 0; i< word.length; i++){
            index = word[i]-'a';
            if(crawl.children[index]==null)
                return false;
            crawl = crawl.children[index];
        }
        return crawl.isEnd;
    }

    // initialize root
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    // insert each word from dictionary into trie
    public void buildDict(String[] dictionary) {
        for(String word: dictionary)
            insert(word);
    }
    
    // function for magic search
    public boolean search(String searchWord) {
        // convert string to char array to check word after replacing a letter
        char[] word = searchWord.toCharArray();
        // traverse through the word
        for(int i = 0; i < word.length; i++){
            // traverse through each letter of alphabet to check if its in the trie
            for(char c = 'a';  c<= 'z'; c++){
                // if the alphabet letter is in our word, we move to next character of search word
                if(word[i]==c)
                    continue;
                // if the alphabet letter is not in our word, replace it
                char temp = word[i];
                word[i] = c;
                // check if new word is a word in the trie, if it is, return true
                if(contains(word))
                    return true;
                word[i] = temp;
            }
        }
        // return false if no changes are made
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */