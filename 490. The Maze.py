#######490. The Maze####################################################################################
// Time Complexity : O(m*n)
// Space Complexity : O(1) -> no extra space as updating matrix itself
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
Here we applied BFS but we will not chose the next element but the element last in specific row and column as the ball can travel till end and when we are inserting element in queue we update its position value to 2 to keep a track we have reached there, and also we check if the position we are inserting in queue is destination if it is the case than we have reached the place

import numpy as np
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        dirlist=[[0,1],[1,0],[0,-1],[-1,0]]
        R,C=len(maze),len(maze[0])
        q1=collections.deque()
        q1.append(start)
        while len(q1)>0:
            curr=q1.popleft()
            r,c=curr[0],curr[1]
            #maze[r][c]=2
            for i in dirlist:
                #print(i)
                nr,nc=r+i[0],c+i[1]
                if nr<R and nc<C and nr>=0 and nc >=0 and maze[nr][nc]!=1 and  maze[nr][nc]!=2:
                    #print('in if')
                    while nr<R and nc<C and nr>=0 and nc >=0 and maze[nr][nc]!=1:
                        #print('while loop',nr,nc)
                        nr,nc=nr+i[0],nc+i[1]
                    #print('nr,nc',nr,nc)
                    #if i[0]==0:
                    nr,nc=nr-1*i[0],nc-1*i[1]
                    #else:
                    #    nr,nc=nr-1*i[0],nc
                    if nr==destination[0] and nc==destination[1]:
                            return True
                    if maze[nr][nc]!=2:
                        q1.append([nr,nc])
                        maze[nr][nc]=2
                    

                #print(q1)


        #print(np.array(maze))
        return False
        
        
        
