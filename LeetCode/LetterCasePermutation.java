/*
Given a string s, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order.

 

Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]
Example 3:

Input: s = "12345"
Output: ["12345"]
Example 4:

Input: s = "0"
Output: ["0"]
*/

class Solution {
    public List<String> letterCasePermutation(String s) {
        // declare result
        List<String> result = new ArrayList<>();
        // make string to store each permutation
        String str = "";
        // backtrack
        backtrack(result, str, s, 0);
        // return result
        return result;
    }
    
    public void backtrack(List<String> result, String str, String s, int i){
        // add current string when i reaches strings length
        if (i == s.length()){
            result.add(str);
            return;
        }
        // iterate through selection list
        char x = s.charAt(i);
        if(Character.isLetter(x)){
            // the selection list
            char arr[] = new char[]{Character.toLowerCase(x), Character.toUpperCase(x)};
            for(char c: arr){
                    // add to selection list
                    str = str + c;
                    backtrack(result, str, s, i+1);
                    // remove from selection list
                    str = str.substring(0,str.length()-1);
            }
        }
        else {
            str = str + x;
            backtrack(result, str, s, i+1);
            str = str.substring(0,str.length()-1);
        }
    }
}