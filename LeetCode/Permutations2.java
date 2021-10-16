/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        boolean used[] = new boolean[nums.length];
        backtrack(result, path, nums, used);
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> path, int[] nums, boolean used[]){
        // end condition
        if(path.size() == nums.length && !result.contains(path)){
            result.add(new ArrayList<>(path));
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            // mark visited
            used[i] = true;
            path.add(nums[i]);
            backtrack(result, path, nums, used);
            // demark 
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}