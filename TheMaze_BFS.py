# TC: O(M x N) where M is the number of rows and number of columns. 
# SC: O(N) where N is the length of the queue being used for performing the BFS.

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze or len(maze) == 0: 
            return False
        
        queue = collections.deque()
        queue.append((start[0],start[1]))
        if start[0] == destination[0] and start[1] == destination[1]: 
            return True
        maze[start[0]][start[1]] = 2
        rows = len(maze)
        cols = len(maze[0])
        
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        while queue: 
            curr_x, curr_y = queue.popleft()
            for i, j in dirs: 
                new_x = i + curr_x
                new_y = j + curr_y
                while new_x >= 0 and new_x < rows and new_y >= 0 and new_y < cols and maze[new_x][new_y] != 1: 
                    new_x += i
                    new_y += j

                new_x -= i
                new_y -= j
                if new_x == destination[0] and new_y == destination[1]: 
                    return True
                
                if maze[new_x][new_y] != 2: 
                    queue.append((new_x, new_y))
                    maze[new_x][new_y] = 2
        
        return False
