class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        #DFS
        
        rows = len(maze)
        cols = len(maze[0])
        visited = set()
        rolling_directions = {
            "left" : (0,-1),
            "right": (0,1),
            "up" : (-1, 0),
            "down": (1,0)
        }
        
        queue = deque([[start[0],start[1]]])
        visited.add((start[0], start[1]))
        while queue:
            i, j = queue.popleft()
        
            for dir in rolling_directions:
                x, y = rolling_directions[dir]
                row, col = i,j
                print(dir)
                while 0<=x+row<rows and 0<=y+col<cols and maze[x+row][y+col]==0:
                    row=row+x
                    col=col+y
                # print(i,j)
                if [i,j] == destination:
                    return True
                if (row,col) not in visited:
                    queue.append([row,col])
                    visited.add((row, col))
            
        return False
        
  Time: O(MN)
  Space: O(MN)
