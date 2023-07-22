#Time Complexity:O(mxn)
#Space Complexity:O(mxn)

class Solution():
    def dfs(self,maze,i,j,end):
        #base
        if maze[i][j]==2:
            return False
        if i==end[0] and j==end[1]:
            return True
        
        #logic
        maze[i][j]=2
        dire=[[0,1],[0,-1],[1,0],[-1,0]]
        for ele in dire:
            nr=i
            nc=j
            while nr>=0 and nr<len(maze) and nc>=0 and nc<len(maze[0]) and maze[nr][nc]!=1:
                nr=nr+ele[0]
                nc=nc+ele[1]
            nr=nr-ele[0]
            nc=nc-ele[1]
            if self.dfs(maze,nr,nc,end):
                return True
        return False

            
        
    def findPath(self,maze,start,end):
        if len(maze)==0: 
            return False
        return True if start==end else self.dfs(maze,start[0],start[1],end)
        
maze=[[0 ,0 ,1, 0, 0],[0, 0, 0 ,0 ,0],[0,0 ,0 ,1, 0],[1 ,1 ,0 ,1 ,1],[0 ,0 ,0 ,0, 0]]
start=[0,4]
end=[4,4]
a=Solution()
print(a.findPath(maze,start,end))