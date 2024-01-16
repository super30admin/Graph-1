"""
Time Complexity : O(m*n*k) where m is the number of rows of maze matrix and n is the number of columns of maze and k is the number of walls
Space Complexity : O(m*n) where m is the number of rows of maze matrix and n is the number of columns of maze. In worst case, all the positions can be in queue

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
from collections import deque


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = len(maze)
        n = len(maze[0])
        if m == 0 or n == 0:
            return False
        queue = deque()
        queue.append(start)
        maze[start[0]][start[1]] = 2
        directions = [[0, 1], [-1, 0], [0, -1], [1, 0]]
        while queue:
            position = queue.popleft()
            possiblePositions = self.findStops(maze, position[0], position[1])
            print(possiblePositions)
            for i, j in possiblePositions:
                if destination[0] == i and destination[1] == j:
                    return True
                queue.append([i, j])
                maze[i][j] = 2
        return False

    def findStops(self, maze, i, j):
        directions = [[0, 1], [-1, 0], [0, -1], [1, 0]]
        m = len(maze)
        n = len(maze[0])
        result = []
        for direction in directions:
            nr = i
            nc = j

            while nr >= 0 and nr < m and nc >= 0 and nc < n and maze[nr][nc] != 1:
                nr = nr + direction[0]
                nc = nc + direction[1]
            nr -= direction[0]
            nc -= direction[1]
            if maze[nr][nc] != 2:
                result.append([nr, nc])

        return result
