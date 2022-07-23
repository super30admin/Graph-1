# Approach : Using BFS
# TC: O(mn) as each node may only go once in the queue, K is some constant because
#             we are trying to process each node upto K times but we don't add it to q
#             because it may be marked visited and K may not be very big
# SC: O(mn) linear cause Q will never hold more than mn nodes at a time
from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # init q, m, n
        q = deque()
        m, n = len(maze), len(maze[0])
        # define dirs
        dirs = ((0,1), (1,0), (-1,0), (0,-1))
        # add start point to maze and mark it visited
        q.append(start)
        maze[start[0]][start[1]] = 2
        
        while q:
            i, j = q.popleft()
            for dr, dc in dirs:
                nr = i + dr
                nc = j + dc
                while nr >= 0 and nr < m and nc >=0 and nc < n and maze[nr][nc] != 1:
                    nr += dr
                    nc += dc
                # take 1 step back
                nr -= dr
                nc -= dc
                if maze[nr][nc] != 2:
                    if [nr,nc] == destination:
                        return True
                    maze[nr][nc] = 2
                    q.append((nr,nc))
        return False

# Approach : Using DFS
# TC: O(mn)
# SC: O(mn)
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # init m, n
        m, n = len(maze), len(maze[0])
        # define dirs
        dirs = ((0,1), (1,0), (-1,0), (0,-1))
        # add start point to maze and mark it visited
        
        def dfs(i,j):
            # base
            if [i,j] == destination:
                return True
            # logic
            maze[i][j] = 2
            for dr, dc in dirs:
                nr = i
                nc = j
                while nr >= 0 and nr < m and nc >=0 and nc < n and maze[nr][nc] != 1:
                    nr += dr
                    nc += dc
                # take 1 step back
                nr -= dr
                nc -= dc
                # ensure the nr,nc is not 1 or 2
                if maze[nr][nc] == 0:
                    # call DFS and if dfs returns True, then return True
                    if dfs(nr,nc): return True
            return False

        return dfs(*start)