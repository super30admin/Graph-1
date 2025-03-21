# Time Complexity : O(mxn)
# Space Complexity : O(mxn)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        R,C = len(maze), len(maze[0])

        visited = set()

        res = [False]

        def inBounds(r,c):
            return 0<=r<R and 0<=c<C

        def dfs(node):
            visited.add(node)
            r,c = node
            for di,dj in [[0,1],[0,-1],[-1,0],[1,0]]:
                dr,dc = r,c
                while inBounds(dr,dc) and maze[dr][dc] != 1:
                    dr += di
                    dc += dj
                # step back
                dr -= di
                dc -= dj
                if dr == destination[0] and dc == destination[1]:
                    return True
                if (dr,dc) not in visited:
                    if dfs((dr,dc)):
                        return True
            return False
        
        return dfs((start[0],start[1]))