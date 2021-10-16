'''
Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.
Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small pounds 1 and 3 units trapped.
The total volume of water trapped is 4.
'''

import heapq
class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        # To ensure the calculation of the height of the water is correct,
        # a binary heap is needed to process cells from the lowest height,
        # and the stored values in the heap are representation of boundries.
        
        # In other words, the lowest possible level of water is recorded
        # as the boundries are shrinking/processed, therefore:
        #   for every boundry, check if there's a cell lower than it,
        #   if there is, then the volume of water at that cell MUST be 
        #   the current level of water - the height of that lower cell
        
        # to record visited cell, modify the cell to -1
        
        if not heightMap or not heightMap[0]:
            return 0
        
        n, m = len(heightMap), len(heightMap[0])
        heap = [] # height, x, y
        for i in range(n):
            for j in range(m):
                if i == 0 or i == n - 1 or j == 0 or j == m - 1:
                    heapq.heappush(heap, (heightMap[i][j], i, j))
                    heightMap[i][j] = -1
        
        res, level = 0, 0
        
        while heap:
            height, x, y = heapq.heappop(heap)
            level = max(height, level)
            
            for i, j in [(x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1)]:
                if 0 <= i < n and 0 <= j < m and heightMap[i][j] != -1:
                    heapq.heappush(heap, (heightMap[i][j], i, j))
                    if heightMap[i][j] < level:
                        res += level - heightMap[i][j]
                    heightMap[i][j] = -1
        
        return res