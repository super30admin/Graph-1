#Time Complexity :O(m*n)
#Space Complexity :O(m*n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m=len(maze)
        n=len(maze[0])
        q=deque()
        q.append((start[0],start[1]))
        maze[start[0]][start[1]]=2
        dirs=[(-1,0),(0,-1),(1,0),(0,1)]
        while q:
            curr=q.popleft()
            for dir in dirs:
                r=curr[0]
                c=curr[1]
                while r>=0 and r<m and c>=0 and c<n and maze[r][c]!=1:
                    r+=dir[0]
                    c+=dir[1]
                r-=dir[0]
                c-=dir[1]
                if r==destination[0] and c==destination[1]:
                    return True
                if maze[r][c]!=2:
                    q.append((r,c))
                    maze[r][c]=2
        return False
