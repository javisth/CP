/*
Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:

Input: n = 1, k = 1
Output: [[1]]
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // define returning result
        List<List<Integer>> result = new ArrayList<>();
        // combination list for each combination
        List<Integer> combination = new ArrayList<>();
        // we need the list of numbers
        int nums[] = new int[n];
        for(int i=1; i<=n; i++)
            nums[i-1] = i;
        // call backtrack
        backtrack(result, combination, nums, k, 0);
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> combination, int nums[], int k, int start){
        // if we have our desired combination size, add it
        if(combination.size() == k)
            result.add(new ArrayList<>(combination));
        // iterate through each element starting at start to avoid elements already checked for
        for(int i = start; i< nums.length; i++){
            // add to path
            combination.add(nums[i]);
            // backtrack
            backtrack(result, combination, nums, k, i+1);
            // remove from path
            combination.remove(combination.size()-1);
        }
    }
}