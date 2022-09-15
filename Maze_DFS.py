# Time : O(m*n)
# Space : O(m*n)
# Leetcode : Solved and submitted

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # direction array to check for neighbors
        self.dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        self.rows = len(maze)
        self.cols = len(maze[0])
        
        # call dfs with the starting position
        return self.dfs(maze, start, destination)
    
    def dfs(self, maze, start, dest):
        # base
        # if we hit the start and dest as same, just return True
        if start[0] == dest[0] and start[1] == dest[1]:
            return True
        
        # mark the current position as visited
        maze[start[0]][start[1]] = 2
        
        # move in all directions
        for di in self.dirs:
            # copy the index as they will be overwritten
            i = start[0]; j = start[1]
            
            # check if we are within boundary and also until we do not reach a 1 
            while i >= 0 and i < self.rows and j >= 0 and j < self.cols and maze[i][j] != 1:
                i += di[0]
                j += di[1]
            
            # Take one step back as we stop when we reach one
            i -= di[0]
            j -= di[1]
            
            # check if the position is not visited
            if maze[i][j] != 2:
              # if dest is the same as current position, then return True
                if i == dest[0] and j == dest[1]:
                    return True
                 
               # call dfs on the next position, if it is true, only then return True
                if self.dfs(maze, [i,j], dest):
                    return True
