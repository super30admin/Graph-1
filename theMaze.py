# Approach : BFS
# TC: O(m*n) as each node will go only once in the queue, K is some constant bcz
#  we are trying to process each node upto K times but we don't add it to queue
#  because it may be marked visited and K may not be very big
# SC: O(m*n) linear cause Q will never hold more than mn nodes at a time
from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
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
                if maze[nr][nc] != 2:
                    if [nr,nc] == destination:
                        return True
                    maze[nr][nc] = 2
                    queue.append((nr, nc))
        return False

# Approach : Using DFS
# TC: O(mn)
# SC: O(mn)
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