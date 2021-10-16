/*
You are given a sorted unique integer array nums.

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
Example 3:

Input: nums = []
Output: []
Example 4:

Input: nums = [-1]
Output: ["-1"]
Example 5:

Input: nums = [0]
Output: ["0"]
*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        // define result for return type
        List<String> result = new ArrayList<>();
        // do some error checking
        if(nums.length == 0)
            return result;
        // pointer variables for sliding window
        int i = 0, j = 0;
        // build string with first element
        String s = "" + nums[0];
        for(i = 1; i < nums.length; i++){
            // check for consecutive numbers and track the range of the sequence
            if((nums[i]-nums[i-1])==1){
                j++;
                continue;
            }
            // the moment there's a gap in the sequence
            else{
                // if the sequence length is more than 0, build the range string
                if(j>0){
                    s = s+"->"+nums[i-1];
                }
                // add the current range in the result either way
                result.add(s);
                // set the new starting range in string
                s = "" + nums[i];
                // reset pointer to track new range
                j = 0; 
            }
        }
        // case for 1 or 2 elements in the array
        // if the range length is still more than 0, build the range
        if(j > 0){
            s = s+"->"+nums[nums.length-1];
        }
        // add the first range element either way
        result.add(s);
            
    
        return result;
    }
}
