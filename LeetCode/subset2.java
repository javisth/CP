
/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // declare result
        List<List<Integer>> result = new ArrayList<>();
        // make a subset using set to keep track of current subsets without duplicates
        //List<List<Integer>> tempres = new HashSet<>();
        List<Integer> subset = new ArrayList<>();
        // sort list
        Arrays.sort(nums);
        // call backtrack
        backtrack(result, subset, nums, 0);
        // return result
        //for(List<Integer> i: tempres)
            //result.add(i);
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> subset, int nums[], int start){
        // add current subset to result as a deep copy
        result.add(new ArrayList<>(subset));
        // iterate through each element
        for(int i = start; i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            // add current element to subset
            subset.add(nums[i]);
            // backtrack on next element
            backtrack(result, subset, nums, i+1);
            // remove last visited element from tree
            subset.remove(subset.size()-1);
        }
    }
}