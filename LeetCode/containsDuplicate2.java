/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       // we need to keep track of elements in the array and their indices
        // it makes sense to use a hashmap or hashset to check if an element has occured
        // we will essentially store each element in the map and check if a duplicate element exists later on in the array
        HashMap<Integer, Integer> map = new HashMap<>();
        // lets traverse through the array elements
        for(int i = 0; i< nums.length; i++){
            // lets store our current element
            int current = nums[i];
            // lets check if it satisifies our conditions
            if(map.containsKey(current) && i - map.get(current) <= k)
                return true;
            // if it doesnt, we just put it in our map
            else
                map.put(current, i);
        }
        // if it doesnt return true above, we return false
        return false;
    }
}