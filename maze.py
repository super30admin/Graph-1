"""
explore all 4 directions 
TC: O(m*n)
SP:O(m*n) stack space
"""
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        m = len(maze)
        n = len(maze[0])
        def helper(i, j):
            if i==destination[0] and j==destination[1]:
                return True
            if maze[i][j]==-1:
                return False
            maze[i][j] = -1
            for dr, dc in directions:
                nr, nc= i+dr, j+dc
                while 0<=nr<m and 0<=nc<n and maze[nr][nc]!=1:
                    nr+=dr
                    nc+=dc
                nr-=dr
                nc-=dc
                if (helper(nr, nc)): return True
            return False
        return helper(start[0], start[1])

                    