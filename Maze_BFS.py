# Time complexity : O(m*n + k(m+n)) = O(m*n) --> k(m+n) is for traversing the matrix for 0's
# Space complexity : O(m*n)
from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # check if start is the destination
        if start[0] == destination[0] and start[1] == destination[1]:
            return True
          
        # direction array to move in 4 directions
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        rows = len(maze)
        cols = len(maze[0])
        
        # maintain a queue for the matrix position of the ball
        q = deque([])
        q.append(start[0]); q.append(start[1])
        
        # mark the start position as visited
        maze[start[0]][start[1]] = 2
        
        # traverse until the q is empty
        while q:
          # pop the index position from which we have to traverse
            row = q.popleft(); col = q.popleft()
            for di in dirs:
                # copy the row and col as it will be overwritten
                i = row
                j = col
                
                # check for boundary conditions and we move until we reach 1
                while i >=0 and i < rows and j >= 0 and j < cols and maze[i][j] != 1:
                    i += di[0]
                    j += di[1]
                
                # take one step back as we stop the above while loop when we reach 1, so pointing to a 0 after the below steps
                i -= di[0]
                j -= di[1]
                
                # check if the index is not visited
                if maze[i][j] != 2:
                  # check if this is the destination
                    if i == destination[0] and j == destination[1]:
                        return True
                    # mark it visited and add it to the queue
                    maze[i][j] = 2
                    q.append(i); q.append(j)
        # return False if after iterating all the empty spaces in maze, we couldn't reach the destination
        return False
