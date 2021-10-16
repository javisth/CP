/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
*/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        // define result to return
        int result = 0;
        
        // create a visited array to track vertices
        boolean[] visited = new boolean[isConnected.length];
        
        // create stack for dfs
        Stack<Integer> stack = new Stack<>();
        
        // iterate through each vertex
        for(int i = 0; i<isConnected.length; i++){
            // check if element is visited
            if(!visited[i]){
                // increment connected component count
                result++;
                
                // add element to stack
                stack.push(i);
                // find each neighbour of element
                while(!stack.isEmpty()){
                    int top = stack.pop();
                    visited[top] = true;
                    
                    for(int j = 0; j < isConnected[top].length; j++){
                        if(!visited[j] && isConnected[top][j]==1){
                            stack.push(j);
                        }
                    }
                }
            }
        }
        return result;
    }
}