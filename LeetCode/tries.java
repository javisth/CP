// Tries

import java.util.*;

public class tries
{
	// static instance variable constant
	static final int ALPHABET_SIZE = 26;

	// lets define a trie node helper class and declare it as static
	static class TrieNode{
		// define instance variables

		// children node array
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];

		// boolean variable to track end of word 
		boolean endWord;

		// define constructor for this class
		TrieNode(){

			endWord = false;
			for(int i = 0; i < ALPHABET_SIZE; i++){
				children[i] = null;
			}
		}
	}

	// define the root of a TrieNode
	static TrieNode root;

	// define insert function for trie keys
	static void insert(String key){

		// index to track children
		int index;
		// store current node to traverse the key
		TrieNode crawl = root;
		// iterate through key to check and store each character as a node
		for(int i = 0; i < key.length(); i++){
			// index of key character in the children array
			index = key.charAt(i) - 'a';
			// if node is not in tree, add it to the tree
			if(crawl.children[index] == null){
				crawl.children[index] = new TrieNode();
			}

			// if the node exists, move to the next child node
			crawl = crawl.children[index];
		}

		// after we traverse the key, mark the last child node as leaf
		crawl.endWord = true;
	}

	// define search function for trie keys
	static boolean search(String key)
	{
		// index to track children
		int index;
		// store current node to traverse the key
		TrieNode crawl = root;
		// iterate through key to search for it in the tree
		for(int i = 0;i< key.length(); i++){
			// index of key character in the children array
			index = key.charAt(i) - 'a';
			// if any character of the key is not in tree, key is not in tree
			if(crawl.children[index] == null){
				return false;
			}

			// if the node exists, move to the next child node
			 crawl = crawl.children[index];
		}
		// return whether the key was found by checking last leaf
		return crawl.endWord;
	}

	// check if a node has no children
	static boolean isEmpty(TrieNode node){
		// iterate over each letter to check if its a child of a node or not
		for(int i = 0; i < ALPHABET_SIZE; i++){
			if(node.children[i] != null)
				return false;
		}
		return true;
	}
	// delete a key from the tree
	static TrieNode delete(TrieNode node, String key, int depth)
	{
		// if the current node is empty, return null
		if(node == null){
			return null;
		}

		// if we've reached the last character of key
		if(depth == key.length()){
			// if the last character is the end of word, mark it to be no more
			if(node.endWord)
				node.endWord = false;

			// if the node has no child(its not a prefix of another word), delete it by marking it null
			if(isEmpty(node)){
				node = null;
			}
			// return the current node after this is done
			return node;
		}

		// we want to get to the bottom of the tree if node is not last character
		// get index of key character in our tree
		int index = key.charAt(depth) - 'a';
		// recurse on the child node
		root.children[index] = delete(node.children[index], key, depth+1);

		// if the node has no more children and its not the end of a word, delete it by setting root to null
		if(isEmpty(node) && node.endWord == false){
			node = null;
		}

		return node;
	}

	static int indices;
	// helper function to count children
	static int countChildren(TrieNode node){
		int count = 0;
		indices = 0;
		// if the node is null, return 0
		if(node == null)
			return count;
		// iterate through each alphabet to find child
		for(int i = 0; i < ALPHABET_SIZE; i++){
			// if child is found increment total no. of children and also store the index of the child
			if(node.children[i] != null){
				count++;
				// store the index of the child
				indices = i;
			}
		}
		return count;
	}

	// longest common prefiz
	static String longestCommonPrefix()
	{
		TrieNode crawl = root;
		// build string for prefix
		String prefix = "";

		while(countChildren(crawl) == 1 && crawl.endWord == false){
				// store the child retreived from the child index
				prefix += (char)(indices + 'a');
				// move to the next child
				crawl = crawl.children[indices];
		}

		return prefix;
	}


	// collect all tries in keys
	static List<String> collect(TrieNode word, String str, List<String> result)
	{
		// add word to resulting list if we've reached end of word node
		if(word.endWord){
			System.out.println(str);
			result.add(str);
			// we reset end of word in case there are more nodes after marked leaf
			word.endWord = false;
		}

		// use backtracking to iterate over each letter of the alphabet
		for(int i = 0; i < ALPHABET_SIZE; i++){
			// if that particular letter is part of any of our key's , we build our word
			if(word.children[i]!=null){
				// build word by adding character
				str = str + (char)(i+'a');
				// go to next level of the tree to check for next child
				collect(word.children[i], str, result);
				// delete added character
				str = str.substring(0, str.length()-1);
			}
		}
		return result;
	}

	// driver method for program
	public static void main(String args[])
	{
		String check[] = {"geeksforgeeks", "geeks", "geek", "geezer"};
		// create a new TreeNode and set it as a root
		root = new TrieNode();

		// construct the trie by inserting each word into it
		for(int i = 0; i < check.length; i++){
			insert(check[i]);
		}
		System.out.println(longestCommonPrefix());

		delete(root, "geeksforgeeks", 0);
		delete(root, "geeks", 0);
		delete(root, "geek", 0);
		delete(root, "geezer", 0);

		// Input keys
		String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};

		// create a new TreeNode and set it as a root
		root = new TrieNode();

		// construct the trie by inserting each word into it
		for(int i = 0; i < keys.length; i++){
			insert(keys[i]);
		}

		// this display only works if its called last because it alters the status of each leaf in the tree
		List<String> result = new ArrayList<>();

		// lets search for different keys
		/*
		if(search("the") == true)
			System.out.println("Found it");
		else
			System.out.println("Not found");

		if(search("these") == true)
			System.out.println("Found it");
		else
			System.out.println("Not found");

		if(search("their") == true)
			System.out.println("Found it");
		else
			System.out.println("Not found");

		if(search("thaw") == true)
			System.out.println("Found it");
		else
			System.out.println("Not found");
		*/
		System.out.println("Deleting any");
		delete(root, "any", 0);


		// this display only works if its called last because it alters the status of each leaf in the tree
		System.out.println(collect(root, "", result));

	}
	
}