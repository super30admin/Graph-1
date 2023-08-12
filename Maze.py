from typing import (
    List,
)
# Time Complexity : O(m*n)
# Space Complexity : O(m + n), maximum length of path from start to end

# The code ran on Leetcode

# BFS from start index with a visited array. Return True if end can be visited. 
from collections import deque
class Solution:
    """
    @param maze: the maze
    @param start: the start
    @param destination: the destination
    @return: whether the ball could stop at the destination
    """
    def has_path(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # write your code here
        q = deque()
        m = len(maze); n = len(maze[0])
        visited = set()

        q.append(start)
        visited.add((start[0], start[1]))
        
        while q:
            print(q)
            size = len(q)
            for _ in range(size):
                x, y = q.popleft()
                # Move Up
                x1, y1 = x, y
                while x1 - 1 >= 0 and maze[x1-1][y1] != 1:
                    x1-=1
                if (x1, y1) not in visited:
                    q.append([x1, y1])
                    visited.add((x1, y1))

                # Move Down
                x1, y1 = x, y
                while x1 + 1 < m and maze[x1+1][y1] != 1:
                    x1+=1
                if (x1, y1) not in visited:
                    q.append([x1, y1])
                    visited.add((x1, y1))

                # Move Right
                x1, y1 = x, y
                while y1 + 1 < n and maze[x1][y1 + 1] != 1:
                    y1+=1
                if (x1, y1) not in visited:
                    q.append([x1, y1])
                    visited.add((x1, y1))
                # Move Left
                x1, y1 = x, y
                while y1 - 1 >= 0 and maze[x1][y1 - 1] != 1:
                    y1-=1
                if (x1, y1) not in visited:
                    q.append([x1, y1])
                    visited.add((x1, y1))

                if (destination[0], destination[1]) in visited:
                    return True
        return False
                



