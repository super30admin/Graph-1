"""
Time Complexity : O(m*n*k) where m is the number of rows of maze matrix and n is the number of columns of maze and k is the number of walls
Space Complexity : O(m*n) where m is the number of rows of maze matrix and n is the number of columns of maze. In worst case, all the positions can be dfs stack

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = len(maze)
        n = len(maze[0])
        if m == 0 or n == 0:
            return False
        directions = [[0, 1], [-1, 0], [0, -1], [1, 0]]
        return self.dfs(maze, start, destination, directions)

    def dfs(self, maze, curr, destination, directions):
        # base
        if maze[curr[0]][curr[1]] == 2:
            return False
        if curr[0] == destination[0] and curr[1] == destination[1]:
            return True

        # logic
        i = curr[0]
        j = curr[1]
        maze[i][j] = 2
        m = len(maze)
        n = len(maze[0])
        for direction in directions:
            i = curr[0]
            j = curr[1]

            while i >= 0 and j >= 0 and i < m and j < n and maze[i][j] != 1:
                i += direction[0]
                j += direction[1]
            i -= direction[0]
            j -= direction[1]
            newCurr = [i, j]
            if (self.dfs(maze, newCurr, destination, directions)):
                return True

        return False
