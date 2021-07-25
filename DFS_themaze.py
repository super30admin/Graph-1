class Solution:
    def __init__(self):
        self.dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        """
        DFS
        TC:O(m*n^(m+n))
        SC:O(m*n), recursive stack
        """
        if not maze: return False
        
        # right, bottom, left, top
        
        m=len(maze)
        n=len(maze[0])
        return self.dfs(maze, start, destination)
        
    def dfs(self, maze, start, destination):
        m=len(maze)
        n=len(maze[0])
        # base
        if maze[start[0]][start[1]]==2:
            return False
        if start[0]==destination[0] and start[1]==destination[1]:
            return True
        
        # logic
        maze[start[0]][start[1]]=2
        for dirr in self.dirs:
            i=start[0]
            j=start[1]
            while i>=0 and i<m and j>=0 and j<n and maze[i][j]!=1:
                i+=dirr[0]
                j+=dirr[1]
            i=i-dirr[0]
            j=j-dirr[1]
            if self.dfs(maze,[i,j],destination):
                return True
        return False
            
                
            
        