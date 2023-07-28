# Time complexity - O(mn), m rows,n columns.
#  Space complexity - O(mn)

from collections import deque

class Solution:
    def hasPath(self, maze, start, destination):
        if(maze == None):
            return
        if(start[0]==destination[0] or start[1] == destination[1]):
            return True
        q=deque()
        m=len(maze)
        n=len(maze[0])
        dirs=[[0,-1], [0,1], [1,0], [-1,0]]
        q.append(start)
        maze[start[0]][start[1]]=2
        while(len(q)):
            v=q.popleft()
            for dir in dirs:
                i=v[0]
                j=v[1]
                while(i<m and j<n and i>=0 and j>=0 and maze[i][j]!=1):
                    i+=dir[0]
                    j+=dir[1]
                i-=dir[0]
                j-=dir[1]
                if(maze[i][j]!=2):
                    if(i == destination[0] and j==destination[1]):
                        return True
                    q.append([i,j])
                    maze[i][j]=2
        return False

maze=[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
start=[0,4]
d=[3,2]
s=Solution()
print(s.hasPath(maze, start, d))