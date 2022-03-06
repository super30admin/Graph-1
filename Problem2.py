# // Time Complexity : O(mn) where mn is the size of the matrix.  
# // Space Complexity : O(mn) where mn is the size of the matrix.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

class Solution:
    dirs = [[-1,0],[1,0],[0,1],[0,-1]]
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        def dfs(maze,start,destination,visited):
            if start[0] == destination[0] and start[1] == destination[1]:
                return True
            if visited[start[0]][start[1]]:
                return False
            visited[start[0]][start[1]] = True
            for x,y in Solution.dirs:
                nr = start[0] + x
                nc = start[1] + y
                while(nr >= 0 and nr < r and nc >= 0 and nc < c and maze[nr][nc] != 1):
                    nr += x
                    nc += y
                nr -= x
                nc -= y
                if dfs(maze,[nr,nc],destination,visited) :
                    return True
            return False
                
        
        
        
        r = len(maze)
        c = len(maze[0])
        visited = [[False for i in range(c)] for j in range(r)]
        return dfs(maze,start,destination,visited)
