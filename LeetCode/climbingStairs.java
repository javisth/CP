/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

class Solution {
    public int climbStairs(int n) {
        // top down dp approach, extra space for size for base case
        int[] dp = new int[n+1];
        // base cases
        // there's 1 way to climb 0 stairs and 1 stair
        dp[0] = 1;
        dp[1] = 1;
        // iterate over each possibility
        for(int i = 2; i<=n; i++){
            // no. of ways to climb i steps is either the previous ways or the one before because max 2
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}