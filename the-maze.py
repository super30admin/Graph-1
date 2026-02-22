#--------Solution 1 : BFS---------------
''' Time Complexity : O(m*n) 
    Space Complexity : O(m*n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m, n = len(maze),len(maze[0])
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        q = deque()
        q.append((start[0],start[1]))
        maze[start[0]][start[1]] = 2
        while q:
            i, j = q.pop()
            for dir in dirs:
                r = dir[0] + i
                c = dir[1] + j

                while 0<=r<m and 0<=c<n and maze[r][c] != 1:
                    r = dir[0] + r
                    c = dir[1] + c

                #step back
                r = -dir[0] + r
                c = -dir[1] + c

                if destination[0] == r and destination[1] == c:
                    return True
                if maze[r][c] != 2:
                    maze[r][c] = 2
                    q.append((r,c))
        
        return False

#--------Solution 2 : DFS---------------
''' Time Complexity : O(m*n) 
    Space Complexity : O(m*n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m, n = len(maze),len(maze[0])
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        self.destination = destination

        def dfs(i, j, maze):
            if [i,j] == destination:
                return True
            maze[i][j] = 2

            for dir in dirs:
                r = dir[0] + i
                c = dir[1] + j

                while 0<=r<m and 0<=c<n and maze[r][c] != 1:
                    r = dir[0] + r
                    c = dir[1] + c

                #step back
                r = -dir[0] + r
                c = -dir[1] + c

                if maze[r][c] != 2:
                    if dfs(r,c,maze):
                        return True
            return False

        return dfs(start[0],start[1],maze)



        