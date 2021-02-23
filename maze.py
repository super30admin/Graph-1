# Time complexity - O(m*n)
# Space Complexity: O(m*n)
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach :BFS

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze is None or len(maze) == 0:
            return False
        
        rows, cols = len(maze), len(maze[0])
        queue = collections.deque()
        queue.append(start)
        maze[start[0]][start[1]] = 2
        dirs = [[1,0], [0,1], [-1,0], [0,-1]]
        
        while len(queue) > 0:
            node = queue.popleft()
            
            if node[0] == destination[0] and node[1] == destination[1]:
                return True
            
            for d in dirs:
                i = node[0]
                j = node[1]
                while i >= 0 and i < rows and j >= 0 and j < cols and (maze[i][j] == 0 or maze[i][j] == 2):
                    i= i + d[0]
                    j = j + d[1]
                
                i -= d[0]
                j -= d[1]
                
                if maze[i][j] != 2:
                    queue.append([i,j])
                    maze[i][j] = 2
                    
        return False