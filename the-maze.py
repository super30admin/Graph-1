"""
Runtime Complexity: O(m*n) where m and n are rows and columns respectively. We perform dfs on m rows and n columns until we reach the destination.
Space Complexity: O(m*n) - recursive stack
The approach behind the algorithm is to mark 2 as visited and perform a dfs from the start location until we reach the destination.
Yes, the code worked on leetcode
Issues while coding - No
"""


class Solution:
    def __init__(self):
        self.dirs =  [[-1,0],[1,0],[0,-1],[0,1]] #up,down,left,right
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if len(maze) == 0:
            return False
        
        return self.dfs(maze,start,destination)
    
    def dfs(self,maze,start,destination):
        if start[0] == destination[0] and start[1]==destination[1]:     #if start's row and column matches the destonation's row and column 
            return True
        
        maze[start[0]][start[1]]=2
        for dir in self.dirs:
            i = start[0]
            j = start[1]
            
            while (i<len(maze) and j<len(maze[0]) and i>=0 and j>=0 and maze[i][j]!=1):
                i = i + dir[0]
                j = j + dir[1]
            i = i- dir[0]
            j = j- dir[1]
            if ((maze[i][j]!=2) and self.dfs(maze,[i,j],destination)):
                return True
        return False
                
        
         
        