class NumberOfIslands:
    
    def numIslands(self, grid: List[List[str]]) -> int:
        # first do some error checking to see if the data exists
        if grid == None or len(grid) == 0:
            return 0
        # what we have to return
        numIslands = 0
        # lets traverse the entire grid
        for i in range(0,len(grid)):
            for j in range(0,len(grid[i])):
                # find a 1 since its the only thing we care about
                if grid[i][j] == "1":
                    numIslands += self.dfs(grid, i, j)
                    # we need to backtrack on adjacent 1's
        return numIslands
    
    def dfs(self,grid, i, j):
        # lets do some error checking for whether coordinates are outside grid
        if i<0 or i>=len(grid) or j<0 or j>=len(grid[i]) or grid[i][j] == "0":
            return 0
        # set current island to 0 to avoid revisiting it
        grid[i][j] = "0"
        # backtracking and visiting adjacent islands
        self.dfs(grid,i+1,j)
        self.dfs(grid,i-1,j)
        self.dfs(grid,i,j-1)
        self.dfs(grid,i,j+1)
        return 1