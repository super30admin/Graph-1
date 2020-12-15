# Time:- O(mn)
# Space:- O(mn) Using a seen set
# Approach:- Found it extremely hard to code this one, so will have a look at it again in a few days. The basic idea is to do dfs and then change directions only after hitting an obstruction, the only way it differs from normal dfs problems is in this we are forced to go in one direction till we hit an obstruction. In any grid problems we use a seen set so that we dont explore an already explored path again which is what we are doing here as well.

class Solution:
    def hasPath(self, maze, start, destination) -> bool:
        m, n, seen = len(maze), len(maze[0]), set()
        def dfs(i, j):
            if [i, j] == destination: return True
            for dx, dy in ((0,-1),(0,1),(-1,0),(1,0)):
                x, y = i, j
                while 0 <= x+dx < m and 0 <= y+dy < n and not maze[x+dx][y+dy]:
                    x, y = x+dx, y+dy
                if (x,y) not in seen: 
                    seen.add((x,y))
                    if dfs(x,y): return True
            return False
        return dfs(*start)