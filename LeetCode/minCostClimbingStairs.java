/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // top down dp approach where we alter the coins array according to mins
        // start at the 3rd last step to take the minimum cost of the last 2 steps
        for(int i = cost.length-3; i>=0; i--){
            // update each cost to be the minimum of the next 2 steps plus its own
            cost[i] += Math.min(cost[i+1], cost[i+2]);
        }
        // by the end of it either of the 1st 2 steps will have total minimum costs
        // decide which first step to take for minimum cost
        return Math.min(cost[0], cost[1]);
    }
}