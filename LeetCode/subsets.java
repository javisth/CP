/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
*/

class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        // first declare result
        List<List<Integer>> result = new ArrayList<>();
        // list to store each subset as it gets updated
        List<Integer> subset = new ArrayList<Integer>();
        // sort all elements of array just in case
        Arrays.sort(nums);
        // call backtrack function on 1st element
        backtrack(result, subset, nums, 0);
        // return result
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> subset, int nums[], int start){
        // add the current subset as a deep copy
        result.add(new ArrayList<Integer>(subset));
        // iterate through each element in number list starting from specified index
        for(int i = start; i<nums.length; i++){
            // add current element to subset
            subset.add(nums[i]);
            // call backtrack function on next element to explore
            backtrack(result, subset, nums, i+1);
            // remove the last explored element once end of tree is reached
            subset.remove(subset.size()-1);
        }
        
    }
}