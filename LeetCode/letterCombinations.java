/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        // define result type
        List<String> result = new ArrayList<>();
        // lets do some error checking
        if(digits == null || digits.length()==0){
            return result;
        }
        // lets build a mapping from numbers to letters
        String[] mapping = {"0","1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"};
        // we can use recusion to track possibilities in a decision tree
        // lets call a recursive function that will populate our list
        backtrack(result, digits, mapping, "", 0);
        return result;
    }
    public void backtrack(List<String> result, String digits, String[] mapping, String current, int index){
        // base case to terminate recursive loop
        if(index == digits.length()){
            result.add(current);
            return;
        }
        // get mapping of current digit that needs processing 
        String letters = mapping[digits.charAt(index)-'0'];
        // iterate over all elements in the mapping
        for(int i = 0; i<letters.length(); i++){
            // add current letter to current string
            current = current + letters.charAt(i);
            // recusively build the string by moving to next digit
            backtrack(result, digits, mapping, current, index+1);
            // remove added letter
            current = current.substring(0, current.length()-1);
        }
    }
}