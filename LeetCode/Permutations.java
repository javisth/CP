/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // define result for return
        List<List<Integer>> result = new ArrayList<>();
        // temp list to keep track of path
        List<Integer> temp = new ArrayList<>();
        // perform backtrack
        backtrack(result, temp, nums);
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums){
        
        // end condition: if path size covers all elements in array, add it as a solution
        if(temp.size() == nums.length){
            // add the solution as a deep copy otherwise temp will always be empty
            result.add(new ArrayList<>(temp));
        }
        // iterate through each element in selection list
        for(int i = 0; i < nums.length; i++){
            // we want to avoid elements already in the list
            if(temp.contains(nums[i])) continue;
            // build path by selecting element
            temp.add(nums[i]);
            // perform backtrack
            backtrack(result, temp, nums);
            // remove added element
            temp.remove(temp.size()-1);
        }
        
    
    }
}