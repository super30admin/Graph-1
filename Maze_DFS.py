#Time complexity: O(m*n)
#Space Complexity: O(m*n)

#Using DFS
from typing import List


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m=len(maze)
        n=len(maze[0])
        directions=[[0,1],[0,-1],[1,0],[-1,0]]
        return self.DFS(start[0],start[1],maze,m,n,directions,destination)

    def DFS(self,i,j,maze,m,n, directions,destination):
        if i==destination[0] and j==destination[1]:
            return True
        if maze[i][j]==2:
            return False
        for d in directions:
            maze[i][j] = 2
            ni=i+d[0]
            nj=j+d[1]
            while ni>=0 and ni<m and nj>=0 and nj<n and maze[ni][nj]==0:
                ni=ni+d[0]
                nj=nj+d[1]
            ni=ni-d[0]
            nj=nj-d[1]
            if maze[ni][nj]!=2:
                if self.DFS(ni,nj,maze,m,n,directions,destination):
                    return True
        return False


sol = Solution()
res=sol.hasPath([[0 ,0 ,1 ,0 ,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1 ,1],[0,0,0,0,0]],[0, 4],[3, 4])
print(res)
