"""
There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). 
The ball can go through the empty spaces by rolling up, down, left or right, 
but it won't stop rolling until hitting a wall. 
When the ball stops, it could choose the next direction.

Given the m x n maze, the ball's start position and the destination, 
where start = [startrow, startcol] and destination = [destinationrow, destinationcol], 
return true if the ball can stop at the destination, otherwise return false.

You may assume that the borders of the maze are all walls
"""

# Time Complexity : O(mn)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List
from collections import deque 

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        # null case
        if maze is None or len(maze) == 0:
            return False
        
        dirs = [[-1,0], [1,0], [0,-1], [0,1]]
        m = len(maze)
        n = len(maze[0])
        curr = []

        if start[0] == destination[0] and start[1] == destination[1]:
            return True
        
        q = []
        q.append(start)
        
        while q:
            curr = q.pop(0)
            
            for dir1 in dirs:
                r = curr[0]
                c = curr[1]
                
                while r >= 0 and r < m and c >= 0 and c < n and maze[r][c] != 1:
                    r += dir1[0]
                    c += dir1[1]
                    
                r -= dir1[0]
                c -= dir1[1]
                
                if r == destination[0] and c == destination[1]:
                    return True
                
                if maze[r][c] != 2:
                    maze[r][c] = 2
                    q.append([r,c])
                    
        return False
                    
                
        
        
        
        


        