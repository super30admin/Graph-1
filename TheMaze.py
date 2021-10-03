"""
Time Complexity : O(m x n) where m is the no of rows and n is no. of cols in maze 
Space Complexity : O(m x n) where m is the no of rows and n is no. of cols in maze
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
from collections import deque 
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if len(maze) == 0:
            return False
        self.m = len(maze)
        self.n = len(maze[0])
        self.dirs = [[0,1], [1,0], [-1,0], [0,-1]]
        return self.dfs(maze, destination, start[0], start[1])
    def dfs(self, maze, destination, row, col):
        # Base
        if row == destination[0] and col == destination[1]: return True
        
        # Logic
        maze[row][col] = 2
        for d in self.dirs:
            r = row
            c = col
            while r >= 0 and r < self.m and c >= 0 and c < self.n and maze[r][c] != 1:
                r = r + d[0]
                c = c + d[1]
            r = r - d[0]
            c = c - d[1]
            if maze[r][c] != 2 and self.dfs(maze, destination, r, c):
                return True
        return False
                
                