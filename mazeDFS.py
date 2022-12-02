#Time: O(m * n * k)
#Space: O(m * n)
#Program ran on leetcode successfully

class Solution:

    def __init__(self, maze):
        self.m = len(maze)
        self.n = len(maze[0])
        self.dirs = [[-1,0], [0,1], [1,0], [0,-1]]


    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]):
        if maze is None or len(maze) == 0:
            return False
        
        return self.dfs(maze, start, destination)
    
    def dfs(self, maze, curr, destination):

        if maze[curr[0]][curr[1]] == 2:
            return False
        
        if curr[0] == destination[0] and curr[1] == destination[1]:
            return True
        
        maze[curr[0]][curr[1]] = 2
        for dir in self.dirs:
            i = curr[0]
            j = curr[1]
            while (i>=0 and j >= 0 and i < m and j < n and maze[i][j] != 1):
                i+=dir[0]
                j+=dir[1]
            
            i += -dir[0]
            j += -dir[1]

            if self.dfs(maze, [i, j], destination):
                return True
        
        return False

