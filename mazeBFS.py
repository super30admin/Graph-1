#Time: O(m * n * k)
#Space: O(m * n)
#Program ran on leetcode successfully

class Solution: 
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]):
        m = len(maze)
        n = len(maze[0])

        if maze is None or len(maze) == 0:
            return False
        
        dirs = [[-1,0], [0,1], [1,0], [0,-1]]
        q = []
        q.append(start)
        maze[start[0]][start[1]] = 2
        while q:
            curr = q[0]
            for dir in dirs:
                i = curr[0]
                j = curr[1]
                while (i >= 0 and j >= 0 and i < m and j < n and maze[i][j] != 1):
                    i += dir[0]
                    j += dir[1]
                
                i += -dir[0]
                j += -dir[1]

                if maze[i][j] != 2:
                    if i == destination[0] and j == destination[1]:
                        return True
                    q.append([i, j])
                    maze[i][j] = 2
        
        return False

