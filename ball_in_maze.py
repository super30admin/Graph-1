# Time complexity - OMax((m*n)(m+n))
# Space complexity - O(m*n)
# (m*n) increases when there are more hurdles but (m+n) decreases
# (m*n) decreased when there are no hurdles but (m+n) increases
# overall TC - O(m*n)
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        queue = deque([start])
        while queue:
            x,y = queue.popleft()
            maze[x][y] = 2

            for i,j in dirs:
                r,c = x + i, y + j
                while 0 <= r < len(maze) and 0 <= c < len(maze[0]) and maze[r][c] != 1:
                    r += i
                    c += j
                # we have to step back when we hit 1 in the loop above
                r -= i
                c -= j
                if r == destination[0] and c == destination[1] : return True # check if dest
                if maze[r][c] != 2:
                    queue.append((r,c))
        return False   


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]

        m = len(maze)
        n = len(maze[0])
        def helper(x,y):
            if maze[x][y] == 2: return 

            if x == destination[0] and y == destination[1] : return True # check if dest

            maze[x][y] = 2
            for i,j in dirs:
                r,c = x + i, y + j
                while 0 <= r < m and 0 <= c < n  and maze[r][c] != 1:
                    r += i
                    c += j
                # we have to step back when we hit 1 in the loop above
                r -= i
                c -= j
                if helper(r,c): return True
            return helper(start[0], start[1])        
