# The hasPath method determines if there is a path in a maze from start to destination.

# Use BFS to explore paths:
# - Move in each direction until hitting a wall using getStoppingPoint.
# - Mark visited positions to avoid revisiting.

# If the destination is reached during BFS, return True.
# Otherwise, return False after exploring all possible paths.

# TC: O(m * n) - Each cell is processed once.
# SC: O(m * n) - Space for the visited set and queue.


from collections import deque
from typing import List

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        directions = [ (1, 0), (-1, 0), (0, 1), (0, -1) ]
        start, destination = tuple(start), tuple(destination)
        m, n = len(maze), len(maze[0])
        def getStoppingPoint(start, direction): 
            dy, dx = direction
            y, x = start
            while 0 <= y + dy < m and 0 <= x + dx < n and maze[y + dy][x + dx] == 0:
                y, x = y + dy, x + dx 
            return (y, x)

        visited = set([start])
        q = deque([start])
        while q:
            s = q.popleft()
            if s == destination:
                return True
            for direction in directions:
                nextS = getStoppingPoint(s, direction)
                if nextS not in visited:
                    visited.add(nextS)
                    q.append(nextS)
        return False

        

        