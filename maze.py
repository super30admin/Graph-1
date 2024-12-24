from queue import Queue

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        dirc = [[-1,0],[1,0],[0,-1],[0,1]]
        n = len(maze)
        m = len(maze[0])
        i,j = start
        q = Queue()
        q.put([i,j])
        maze[i][j] = -1
        while(not q.empty()):
            nr, nc = q.get()
            for d in dirc:
                r = nr + d[0]
                c = nc + d[1]
                if r<n and r>=0 and c>=0 and c<m and maze[r][c] == 0:
                    while(r<n and r>=0 and c>=0 and c<m and maze[r][c] != 1):
                        r = r + d[0]
                        c = c + d[1]
                    r = r - d[0]
                    c = c - d[1]
                    if [r,c] == destination:
                        return True
                    if maze[r][c] == 0:
                        maze[r][c] = -1
                        q.put([r,c])
                        
        return False