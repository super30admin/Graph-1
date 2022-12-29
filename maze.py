#we can make use of dfs approach here
#the directions will be up down left right
'''
Time complexity --> O(n*m)
Space Complexity --> O(m*n) recusrion stack space
'''
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:

        def dfs(row, col,destination, maze, dir):
            if row == destination[0] and col == destination[1]:
                return True
            maze[row][col]=2 #mark this as visited
            for d in dir:
                r = d[0]+row
                c = d[1]+col
                while r>=0 and r<len(maze) and c>=0 and c<len(maze[0]) and maze[r][c]!=1:
                    r = d[0]+r
                    c = d[1]+c
                r = r-d[0]
                c = c-d[1]
                if maze[r][c]!= 2 and dfs(r,c, destination, maze, dir):
                    return True
            return False



        dir = [[-1, 0], [1,0], [0,-1], [0,1]]
        m = len(maze)
        n = len(maze[0])
        if m==1 and n==1:
            return False
        return dfs(start[0], start[1], destination, maze, dir)
        