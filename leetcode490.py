# Time Complexity = O(mn)
# Space Complexity = O(mn)
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m,n = len(maze), len(maze[0])
        visit = set()
        dirs = [(-1,0),(1,0),(0,-1),(0,1)] #UDLR
        def dfs(r,c):
            if (r,c) in visit:
                return False
            visit.add((r,c))
            if [r,c] == destination:
                return True
            for dr,dc in dirs:
                nr,nc = r,c
                while  m > nr+dr >=0  and n > nc + dc >=0 and maze[nr+dr][nc+dc] == 0:
                    nr += dr
                    nc += dc
                if dfs(nr,nc):
                    return True
            return False

        return dfs(start[0], start[1])