# Time Complexity: O(mxn)
# Space Complexity: O(mxn)
class Solution:
    dirs = [(0,1),(-1,0),(1,0),(0,-1)]
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if(maze == None or len(maze)==0):
            return False
    
        m = len(maze)
        n = len(maze[0])
        
        
        return self.dfs(maze, start, destination, m, n)
    
    def dfs(self,maze, start, destinaiton, m, n):
        # base
        if start[0]==destinaiton[0] and start[1]==destinaiton[1]:
            return True
        if(maze[start[0]][start[1]]): 
            return False
        # logic
        maze[start[0]][start[1]] = 2
        
        for dir in self.dirs:
            i = start[0]
            j = start[1]
            
            while(i>=0 and j>=0 and i<m and j<n and maze[i][j] != 1):
                i += dir[0]
                j += dir[1]
                
            i -= dir[0]
            j -= dir[1]
            
            if self.dfs(maze, [i,j], destinaiton, m, n): return True
        return False