#Time Complexity: O(m*n)
#Space Complexity: O(m*n)

import collections
from typing import List

#Using BFS approach for the graph
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m=len(maze)
        n=len(maze[0])
        directions=[[0,1],[0,-1],[1,0],[-1,0]]
        bfs_queue = collections.deque()
        if start[0]==destination[0] and start[1]==destination[1]:
            return True
        i=start[0]
        j=start[1]
        bfs_queue.append([i,j])
        #Mark the node visited to avoid running to infinite loop
        maze[i][j]=2
        while bfs_queue:
            popindex=bfs_queue.popleft()
            i=popindex[0]
            j=popindex[0]
            for d in directions:
                i = i + d[0]
                j = j + d[1]
                #Ball should not stop until it hits the wall, so we are not just moving 1 step but traversing the entire row/column until it hits the wall
                while i>=0 and i<m and j>=0 and j<n and maze:
                    i=i+d[0]
                    j=j+d[1]
                i=i-d[0]
                j=j-d[1]
                if maze[i][j]!=2:
                    if i==destination[0] and j==destination[1]:
                        return True
                    else:
                        bfs_queue.append([i,j])
                        maze[i][j] = 2
        return False
        

sol = Solution()
res=sol.hasPath([[0 ,0 ,1 ,0 ,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1 ,1],[0,0,0,0,0]],[0, 4],[3, 2])
print(res)
