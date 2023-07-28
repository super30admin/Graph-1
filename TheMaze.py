from ast import List


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], des: List[int]) -> bool:
        if maze is None:
            return False
        
        if start[0] == des[0] and start[1] == des[1]:
            return True

        q = [start]
        maze[start[0]][start[1]] = 2

        rows = len(maze)
        cols = len(maze[0])
        dirs = [[1,0], [0, 1], [-1, 0], [0, -1]]

        while q:
            curr = q.pop()

            for d in dirs:
                r = curr[0]
                c = curr[1]

                while 0 <= r < rows and 0 <= c < cols and maze[r][c] != 1:
                    r += d[0]
                    c += d[1]

                r -= d[0]
                c -= d[1]

                if maze[r][c] != 2:
                    if r == des[0] and c == des[1]:
                        return True
                    l = []
                    l.append(r)
                    l.append(c)
                    q.append(l)
                    maze[r][c] = 2

        return False

                    

