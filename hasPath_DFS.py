"""
Input 1: a maze represented by a 2D array
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)
Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Time complexity O(MN)

"""

class Solution:
    def hasPath(self,maze: List[List[int]],start: List[int],destination: List[int])->bool:
        if maze is None or len(maze)==0:
            return False 
        m=len(maze)
        n=len(maze[0])
        self.dirs=[[1,0],[0,-1],[0,1],[-1,0]]
        return self.dfs(maze,start,destination)
    
    def dfs(self,maze,start,destination):
        #base
        if(maze[start[0]][start[1]]==2):
            return False
        if(start[0]==destination[0] and start[1]==destination[1]):
                return True
        
        #logic
        maze[start[0]][start[1]]=2
        for dir in self.dirs:
            i=start[0]
            j=start[1]
            while(i>=0 and j>=0 and i<m and j<n and maze[i][j]!=1):
                    i=i+dir[0]
                    j=j+dir[1]
            i=i-dir[0]
            j=j-dir[1]
            if(self.dfs(maze,[i,j],destination)):
                return True
        return False
    
    