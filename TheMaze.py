------------------------The Maze --------------------------------------------

# Time Complexity : O(MXN)  M is the length of the maze and n is the column of maze
# Space Complexity : O(mXn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I will traverse through te maze untill I reach the 1 or edge of the maze, Once i reach edge I will 
# Make that node visited and move to other direction. If I dont have any direction to go my recursion terminates and
#returns to the previous step. Once I reach destination the recursion will become true. if it does not reach then it will return False,


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze:
            return False
        
        
        def dfs(maze, start, end):
            # Base Cas
            
            if start == end:
                return True
            # Logic
            
            for d in dirs:
                r = start[0]
                c = start[1]
                while r>=0 and r<len(maze) and c>=0 and c<len(maze[0]) and maze[r][c] != 1:
                    r +=d[0]
                    c += d[1]
                r -=d[0]
                c-=d[1]
                if maze[r][c] != 2:
                    maze[r][c] = 2
                    if dfs(maze, [r,c], end):
                        return True
            return False
                
        m = len(maze)
        n = len(maze[0])
        dirs = [[0,1], [0,-1], [1,0], [-1, 0]]
        return dfs(maze, start, destination)