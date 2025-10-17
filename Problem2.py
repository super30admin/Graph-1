"""
TC: O(M times N) The time complexity is dominated by the Breadth-First Search (BFS) traversal. We visit each cell in the M by N grid at most once. The total time is linear with respect to the matrix size.
SC: O(M times N) The space complexity is determined by the queue, which in the worst case can hold all M times N cells.

Approach:

This problem is solved using Breadth-First Search (BFS) to find if a path exists from the start to the end in the maze. The core challenge is simulating the ball's movement: the ball rolls continuously in one direction until it hits a wall ('1') or the maze boundary, and only the final stopping point is considered for the next move.

1.  Initialization: We use a queue for BFS, adding the starting position and marking it as visited by changing the cell value in the maze (to '2').
2.  Rolling Simulation: From the current stopping point, we check all four directions. For each direction, we advance the ball's coordinates (r, c) until it would hit a wall or go out of bounds. We then step back one position to find the actual, valid stopping cell.
3.  Goal and Exploration: If the calculated stopping point is the end, we return True. Otherwise, if this stopping point is unvisited, we mark it as visited and enqueue it to explore rolls from this new position.

If the queue empties without reaching the end, no path exists.

The problem ran successfully on LeetCode.
"""

from collections import deque

class Solution:
    def theMaze(self, maze, start, end) -> bool:
        #code
        if not maze or len(maze) == 0:
            return False
        
        n,m = len(maze), len(maze[0])
        
        dirs = [[0,1], [1,0], [-1,0], [0,-1]]
        q = deque()
        q.append(start)
        maze[start[0]][start[1]] = 2
        
        while q:
            curr = q.popleft()
            #put babies
            for dir in dirs:
                r, c = curr[0], curr[1]
                
                while 0<=r<n and 0<=c<m and maze[r][c] != 1:
                    r += dir[0]
                    c += dir[1]
                
                #step back    
                r -= dir[0]
                c -= dir[1]
                
                if r == end[0] and c == end[1]:
                    return True
                    
                if maze[r][c] != 2:
                    maze[r][c] = 2
                    q.append((r, c))
                    
        return False
    
    

# sol = Solution()
# maze = [
# [0, 0, 1, 0, 0],
# [0, 0, 0, 0, 0],
# [0, 0, 0, 1, 0],
# [1, 1, 0, 1, 1],
# [0, 0, 0, 0, 0] 
# ]
# start = (0,4)
# end = (4,4)
# res = sol.theMaze(maze, start, end)
# print(res)