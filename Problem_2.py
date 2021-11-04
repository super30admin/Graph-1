# Using Queue (BFS)
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze == None or len(maze) == 0:
            return False
        m, n = len(maze), len(maze[0])
        queue = deque()
        queue.append(start)
        maze[start[0]][start[1]] = 2
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        while len(queue):
            curr = queue.pop()
            for direc in dirs:
                i, j = curr[0], curr[1]
                while i >= 0 and i < m and j >=0 and j < n and maze[i][j] != 1:
                    i += direc[0]
                    j += direc[1]
                i -= direc[0]
                j -= direc[1]
                if maze[i][j] != 2:
                    if i == destination[0] and j == destination[1]:
                        return True
                    queue.append([i,j])
                    maze[i][j] = 2
        return False
                


# DFS Solution
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze == None or len(maze) == 0:
            return False
        m, n = len(maze), len(maze[0])
        self.dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        return self.dfs(maze, start, destination, m, n)
    
    def dfs(self, maze: List[List[int]], start: List[int], destination: List[int], m: int, n:int) -> bool:
        # base case
        if start[0] == destination[0] and start[1] == destination[1]:
            return True
        
        # mark visited
        maze[start[0]][start[1]] = 2
        
        for direc in self.dirs:
            i, j = start[0], start[1]
            while i >= 0 and i < m and j >=0 and j < n and maze[i][j] != 1:
                i += direc[0]
                j += direc[1]
            i -= direc[0]
            j -= direc[1]
            newStart = [i,j]
            if maze[i][j] != 2 and self.dfs(maze, newStart, destination, m, n):
                return True
        return False


# Time Complexity: O(m * n * (m + n))
# Space Complexity: O(m * n)