from queue import Queue

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        # BFS
        m = len(maze)
        n = len(maze[0])

        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)] #UpDownLeftRight

        q = Queue()
        q.put(start)
        maze[start[0]][start[1]] = 2

        while not q.empty():
            curr = q.get()
            for dir in directions:
                x = curr[0] + dir[0]
                y = curr[1] + dir[1]
                while(x >=0 and x < m and y >= 0 and y < n and maze[x][y] != 1):
                    x = x + dir[0]
                    y = y + dir[1]
                x = x - dir[0]
                y = y - dir[1]
                if maze[x][y] != 2:
                    if destination[0] == x and destination[1] == y:
                        return True
                    maze[x][y] = 2
                    q.put([x, y])                
        return False


        # DFS
        def DFS(x, y):
            if x == destination[0] and y == destination[1]:
                return True
            
            maze[x][y] = 2
            for dir in self.directions:
                r = x + dir[0]
                c = y + dir[1]
                while (r >=0 and r < len(maze) and c >= 0 and c < len(maze[0]) and maze[r][c] != 1):
                    r = r + dir[0]
                    c = c + dir[1]
                r = r - dir[0]
                c = c - dir[1]
                if maze[r][c] != 2:
                    if DFS(r, c):
                        return True

            return False

        self.directions = [(-1, 0), (1, 0), (0, -1), (0, 1)] #UpDownLeftRight
        return DFS(start[0], start[1])
