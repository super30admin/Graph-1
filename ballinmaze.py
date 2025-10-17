# Time Complexity : O(N*M) where N * M is the size of the matrix
# Space Complexity : O(N*M) as we are using a queue to store the positions 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using BFS to solve this problem.
# I am starting from the start position and exploring all possible paths.
# I am using a queue to store the positions to be explored.
# I am marking the visited positions by changing their value to 2.
# I am doing this to save space instead of using a separate visited array.
# I am exploring all four directions from each position and moving until I hit a wall.
# If the final position is the destination, then return True.
# If no path is found, return False.

from typing import List
from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = len(maze)
        n = len(maze[0])
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        q = deque([(start[0], start[1])]) 
        maze[start[0]][start[1]] = 2
        while q:
            r,c = q.popleft()
            for dr,dc in dirs:
                nr = r + dr
                nc = c + dc
                while nr < m and nr >= 0 and nc < n and nc >= 0 and maze[nr][nc] != 1:
                    nr += dr
                    nc += dc
                nr -= dr
                nc -= dc
                if nr == destination[0] and nc == destination[1]:
                    return True
                if maze[nr][nc] != 2:
                    q.append((nr,nc))
                    maze[nr][nc] = 2
        return False

                

        