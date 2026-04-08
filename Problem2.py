# https://leetcode.com/problems/the-maze/description/ 

# BFS with queue implementation as this problem needs to traverse the graph with connected components. 
# TC: No walls => O(m*n) * O(m+n) 
# SC: O(m*n)
from typing import List
from collections import deque

class Solution:
    def hasPath(self, maze: List[List[int]], start, destination) -> bool:
        dirs = [(-1,0), (1,0), (0,-1), (0,1)]
        m = len(maze)
        n = len(maze[0])
        
        q = deque()
        q.append(start)
        
        # mark visited
        maze[start[0]][start[1]] = -1
        
        while q:
            curr = q.popleft()
            
            for dir in dirs:
                r = dir[0] + curr[0]
                c = dir[1] + curr[1]
                
                while r >= 0 and c >= 0 and r < m and c < n and maze[r][c] != 1:
                    r += dir[0]
                    c += dir[1]
                    
                r -= dir[0]
                c -= dir[1]
                
                if r == destination[0] and c == destination[1]: return True
                
                if maze[r][c] != -1:
                    q.append([r,c])
                    maze[r][c] = -1
                
        return False
    
if __name__ == "__main__":
    maze = [[0,0,1,0,0],
            [0,0,0,0,0],
            [0,0,0,1,0],
            [1,1,0,1,1],
            [0,0,0,0,0]]

    start = [0, 4]
    destination = [4, 4]

    sol = Solution()
    print(sol.hasPath(maze, start, destination))

# DFS Solution
# TC: O(m*n)
# SC: O(m*n)
from typing import List

class Solution:
    def hasPath(self, maze: List[List[int]], start, destination) -> bool:
        self.dirs = [(-1,0), (1,0), (0,-1), (0,1)]
        self.m = len(maze)
        self.n = len(maze[0])
        
        return self.helper(maze, start[0], start[1], destination)
    
    def helper(self, maze, i, j, destination) -> bool:
        
        if i == destination[0] and j == destination[1]: return True
        if maze[i][j] == -1: return False
        
        maze[i][j] = -1
        
        for dir in self.dirs:
            r = dir[0] + i
            c = dir[1] + j
            
            while r >= 0 and c >= 0 and r < self.m and c < self.n and maze[r][c] != 1:
                r += dir[0]
                c += dir[1]
            
            r -= dir[0]
            c -= dir[1]
            
            if self.helper(maze, r, c, destination): return True
            
        return False
        
    
if __name__ == "__main__":
    maze = [[0,0,1,0,0],
            [0,0,0,0,0],
            [0,0,0,1,0],
            [1,1,0,1,1],
            [0,0,0,0,0]]

    start = [0, 4]
    destination = [4, 4]

    sol = Solution()
    print(sol.hasPath(maze, start, destination))