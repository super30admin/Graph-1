from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        m, n = len(maze), len(maze[0])
        q = deque()
        q.append(start)

        while q:
            x, y = q.popleft()
            for i, j in directions:   
                newX, newY = x, y          
                while newX >= 0 and newY >= 0 and newX < m and newY < n and maze[newX][newY] != 1:
                    newX, newY = newX + i, newY + j
                newX -= i
                newY -= j
                if maze[newX][newY] == 2:
                    continue
                if newX == destination[0] and newY == destination[1]:
                    return True
                maze[newX][newY] = 2
                q.append([newX, newY])
        return False