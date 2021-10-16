/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // define result variable for return
        int result = 0;
        
        // traverse the grid to look for islands
        for(int i = 0; i< grid.length;i++){
            for(int j = 0; j< grid[0].length;j++){
                if(grid[i][j]==1){
                    result = Math.max(result, dfs(grid, i, j));
                }
            }
        }
        return result;
    }
    
    public int dfs(int[][] grid, int x, int y){
        // bounds check
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]==0)
            return 0;
        
        // visit cell
        grid[x][y] = 0;
        // incremement area
        int max = 1;
        // dfs visit on all neighbouring cells and count number of visits
        max+=dfs(grid, x+1, y);
        max+=dfs(grid, x, y+1);
        max+=dfs(grid, x-1, y);
        max+=dfs(grid, x, y-1);
        
        return max;
    }
}