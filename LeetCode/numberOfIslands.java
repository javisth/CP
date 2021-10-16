/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/

class Solution {
    public int numIslands(char[][] grid) {
        // error check
        if(grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        
        // store result to return
        int result = 0;
        // traverse grid to find 1's
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    // incrememnt found connected component
                    result++;
                    // do a dfs search to visit all neighbours of CC
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }
    
    public void dfs(char[][] grid, int x, int y){
        // check if we are within the bounds of the grid and we are at a 1
        if(x>=grid.length || x < 0 || y>=grid[0].length || y < 0 || grid[x][y]!= '1')
            return;
        
        // mark node as visited
        grid[x][y] = '*';
        
        // do dfs check up down left right
        dfs(grid, x-1, y);
        dfs(grid, x+1, y);
        dfs(grid, x, y-1);
        dfs(grid, x, y+1);
    }
}
