class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:

        ## Approach 2: DFS
        ## T.C = O(m.n)
        ## S.C = O(m.n)
        ROWS = len(maze)
        COLS = len(maze[0])
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def dfs(start, destination):
            nonlocal ROWS, COLS, dirs

            if start[0] == destination[0] and start[1] == destination[1]:
                return True
            
            maze[start[0]][start[1]] = 2

            for i,j in dirs:
                p, q = start[0], start[1]
                while p in range(ROWS) and q in range(COLS) and maze[p][q]!=1:
                    p += i
                    q += j
                
                p -= i
                q -= j
                if maze[p][q] != 2 and dfs([p,q], destination):
                    return True
            
            return False
        
        return dfs(start, destination)

        
        ## Approach 1: BFS
        ## T.C = O(m.n)
        ## S.C = O(m.n)
        ROWS = len(maze)
        COLS = len(maze[0])

        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        queue = [start]
        maze[start[0]][start[1]] = 2

        while queue:
            x, y = queue.pop(0)

            for i, j in dirs:
                p, q = x + i, y + j

                while p in range(ROWS) and q in range(COLS) and maze[p][q]!=1:
                    p += i
                    q += j
                
                p -= i
                q -= j

                if maze[p][q] != 2:
                    if p == destination[0] and q == destination[1]:
                        return True
                    maze[p][q] = 2
                    queue.append([p,q])
        return False
