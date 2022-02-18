# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import collections
from typing import List


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        m, n = len(maze), len(maze[0])
        visited = set() 
        
        queue = collections.deque([(start[0], start[1])])
        
        visited.add((start[0], start[1]))
        
        while queue:
            i, j = queue.popleft()
            if [i,j] == destination:
                return True
            
            for dx, dy in [(0,1), (0,-1), (1, 0), (-1, 0)]:
                new_x, new_y = i, j
                
                # look ahead one step to make sure the next space is valid
                while 0 <= new_x+dx < m and 0 <= new_y+dy < n and maze[new_x+dx][new_y+dy] == 0:
                    new_x += dx
                    new_y += dy
                    
                # mark space as visited upon discovery
                if (new_x, new_y) not in visited:
                    visited.add((new_x, new_y))
                    queue.append((new_x, new_y))
        return False