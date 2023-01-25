"""
FAANMG Problem #116 {Medium} 

490. The Maze

# TC: O(m*n) as each node will go only once in the queue, K is some constant bcz
#  we are trying to process each node upto K times but we don't add it to queue
#  because it may be marked visited and K may not be very big
# SC: O(m*n) linear cause Q will never hold more than mn nodes at a time

Did this code successfully run on Leetcode : Yes

BFS Sol

@name: Rahul Govindkumar
"""

from collections import deque
class Solution:
    def hasPath(self, maze, start, destination) -> bool:
        # check if start is the destination
        if start[0] == destination[0] and start[1] == destination[1]:
            return True
        
        # init q, m, n
        queue = deque()
        m, n = len(maze), len(maze[0])
        # define dirs
        dirs = ((0,1), (1,0), (-1,0), (0,-1))
        # add start point to maze and mark it visited
        queue.append(start)
        maze[start[0]][start[1]] = 2

        while queue:
            i, j = queue.popleft()
            for d_row, d_col in dirs:
                nr = i + d_row
                nc = j + d_col
                while nr >= 0 and nr < m and nc >=0 and nc < n and maze[nr][nc] != 1:
                    nr += d_row
                    nc += d_col
                # take 1 step back
                nr -= d_row
                nc -= d_col
                
                # check if the index is not visited
                if maze[nr][nc] != 2:
                    # check if this is the destination
                    if [nr,nc] == destination:
                        return True
                    
                    # mark it visited and add it to the queue
                    maze[nr][nc] = 2
                    queue.append((nr, nc))
        return False
    
mz=Solution()
maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
start = [0,4]
destination = [3,2]

print(mz.hasPath(maze, start, destination))

maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]] 
start = [0,4]
destination = [4,4]
print(mz.hasPath(maze, start, destination))


"""
DFS 

 
        TC: O(M * N)
        SC: O(M * N)


""" 

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = len(maze)
        n = len(maze[0])

        dirs = ((0,1), (1,0), (-1,0), (0,-1))
        # add start point to maze and mark it visited

        def dfs(i, j):
            # base
            if [i, j] == destination:
                return True
            # logic
            maze[i][j] = 2
            for d_row, d_col in dirs:
                nr = i
                nc = j
                while nr >= 0 and nr < m and nc >=0 and nc < n and maze[nr][nc] != 1:
                    nr += d_row
                    nc += d_col
                # take a step back
                nr -= d_row
                nc -= d_col
                # make sure that nr,nc are not 1 or 2
                if maze[nr][nc] == 0:
                    # call DFS and if dfs returns True, then return True
                    if dfs(nr, nc): return True
            return False

        return dfs(*start)
    
 
"""
DFS 

 
        TC: O(M * N)
        SC: O(M * N)


""" 
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # direction array to check for neighbors
        self.dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        self.rows = len(maze)
        self.cols = len(maze[0])

        # call dfs with the starting position
        return self.dfs(maze, start, destination)

    def dfs(self, maze, start, dest):
        # base
        # if we hit the start and dest as same, just return True
        if start[0] == dest[0] and start[1] == dest[1]:
            return True

        # mark the current position as visited
        maze[start[0]][start[1]] = 2

        # move in all directions
        for di in self.dirs:
            # copy the index as they will be overwritten
            i = start[0]; j = start[1]

            # check if we are within boundary and also until we do not reach a 1 
            while i >= 0 and i < self.rows and j >= 0 and j < self.cols and maze[i][j] != 1:
                i += di[0]
                j += di[1]

            # Take one step back as we stop when we reach one
            i -= di[0]
            j -= di[1]

            # check if the position is not visited
            if maze[i][j] != 2:
              # if dest is the same as current position, then return True
                if i == dest[0] and j == dest[1]:
                    return True

               # call dfs on the next position, if it is true, only then return True
                if self.dfs(maze, [i,j], dest):
                    return True   
    