#Time complexity: O(mn)
#Space complexity: O(mn)
from collections import deque
from typing import (
    List,
)

class Solution:
    """
    @param maze: the maze
    @param start: the start
    @param destination: the destination
    @return: whether the ball could stop at the destination
    """
    def has_path(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # write your code here
        dirs=[[0,1],[-1,0],[1,0],[0,-1]]
        m,n = len(maze),len(maze[0])
        if start==destination:
            return True
        q=deque()
        q.append((start[0],start[1]))
        maze[start[0]][start[1]]=2
        while q:
            r,c=q.popleft()
            for d in dirs:
                i,j=r,c
                while i>=0 and i<m and j>=0 and j<n and maze[i][j]!=1:
                    i+=d[0]
                    j+=d[1]
                i-=d[0]
                j-=d[1]
                if i==destination[0] and j==destination[1]:
                    return True
                if(maze[i][j]!=2):
                    q.append((i,j))
                    maze[i][j]=2
        return False


