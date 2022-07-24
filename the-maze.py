# Time Complexity: O(m*n)
# Space Complexity: O(m+n)
# DFS
class Solution:
    # def has_path(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
    #     # write your code here
    #     self.directions=[[0,1],[1,0],[-1,0],[0,-1]]
    #     m=len(maze)
    #     n=len(maze[0])
    #     return self.dfs(maze,start[0],start[1],destination,m,n)
    # def dfs(self, maze: List[List[int]], i:int,j:int,destination: List[int],m:int,n:int):
    #     if i==destination[0] and j==destination[1]: return True
    #     maze[i][j]=2
    #     for d in self.directions:
    #         r=i
    #         c=j
    #         while r>=0 and c>=0 and r<m and c<n and maze[r][c]!=1:
    #             r=r+d[0]
    #             c=c+d[1]
    #         r=r-d[0]
    #         c=c-d[1]
    #         if maze[r][c]==0:
    #             if(self.dfs(maze,r,c,destination,m,n)): return True
    #     return False
# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# BFS
    def has_path(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # write your code here
        if start[0]==destination[0] and start[1]==destination[1]: return True
        directions=[[0,1],[1,0],[-1,0],[0,-1]]
        m=len(maze)
        n=len(maze[0])
        from collections import deque
        q=deque()
        q.append([start[0],start[1]])
        maze[start[0]][start[1]]=2
        while len(q)!=0:
            cur=q.popleft()
            for d in directions:
                i=cur[0]
                j=cur[1]
                while i>=0 and j>=0 and i<m and j<n and maze[i][j]!=1:
                    i=i+d[0]
                    j=j+d[1]
                i=i-d[0]
                j=j-d[1]
                if maze[i][j]==0:
                    if i==destination[0] and j==destination[1]: return True
                    q.append([i,j])
                    maze[i][j]=2
        return False