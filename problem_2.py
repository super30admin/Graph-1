"""
Time Complexity : O(m*n) 
Space Complexity : O(m*n)- as length of queue increases rapidly and can have max of all at once
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


here, we will use BFS to solve this one. we will put inside the queue all the neighbors and check if its is wall
or not and stop there. If its already visited, we wont do anything, otherwise, we will put that neighbor
inside queue. At the end, if at any point the value taken out of queue equals destination, return True,
otherwise False
"""

from collections import deque


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze:
            return False
        m = len(maze)
        n = len(maze[0])
        q = deque()
        q.append(start)
        maze[start[0]][start[1]] = 2
        dirs = [(0, -1), (-1, 0), (0, 1), (1, 0)]
        while q:
            curr = q.popleft()
            if curr == destination:
                return True
            for d in dirs:
                i = curr[0]
                j = curr[1]
                while i >= 0 and j >= 0 and i < m and j < n and maze[i][j] != 1:
                    i += d[0]
                    j += d[1]
                i -= d[0]
                j -= d[1]
                if maze[i][j] != 2:
                    q.append([i, j])
                    maze[i][j] = 2
        return False
