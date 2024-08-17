from collections import deque
class Solution:

    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        dirs = [
            (-1, 0),  # up
            (1, 0),   # down
            (0, -1),  # left
            (0, 1)    # right
        ]

# Normal BFS
        m = len(maze)
        n = len(maze[0])
        q = deque()
        q.append(start)

        if start == destination :
            return True

        while(len(q) != 0) :
            curr = q.popleft()

            for dir in dirs:

                r = curr[0]
                c = curr[1]
                # you continue a direction till you hit a wall or go out of bounds
                while((r >= 0 and r < m and c >= 0 and c < n) and maze[r][c] != 1 ):
                    r += dir[0]
                    c += dir[1]

                # you have to come one step back since you went out of bounds or found wall
                r -= dir[0]
                c -= dir[1]

                # return then and there if reached destination
                if [r,c] == destination :
                    return True

                # to avoid infinite loop mark visited cells as 2 and only then append
                
                if maze[r][c] != 2:
                    q.append([r,c])
                    maze[r][c] = 2
        
        return False
                


