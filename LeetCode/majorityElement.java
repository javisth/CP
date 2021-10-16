/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/

class Solution {
    public int majorityElement(int[] nums) {
        // error checking
        if(nums.length == 1)
            return nums[0];
        // map each element to its index
        HashMap<Integer, Integer> map = new HashMap<>();
        //iterate through array
        for(int i = 0;i<nums.length;i++){
            // check if number is majority element, if it is, return it
            if(map.containsKey(nums[i]) && map.get(nums[i])+1 > (nums.length/2))
                return nums[i];
            else{
                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            }
        }
        return -1;
    }
}