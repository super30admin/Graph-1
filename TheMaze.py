from collections import deque

#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
    if not maze:
        return False
    que = deque([start])
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    maze[start[0]][start[1]] = 2
    while que:
        currX, currY = que.popleft()
        if currX == destination[0] and currY == destination[1]:
            return True

        for x, y in directions:
            newX = currX + x
            newY = currY + y

            while newX >= 0 and newX < len(maze) and newY >= 0 and newY < len(maze[0]) and maze[newX][newY] != 1:
                newX = newX + x
                newY = newY + y
            newX = newX - x
            newY = newY - y
            if maze[newX][newY] != 2:
                maze[newX][newY] = 2
                que.append((newX, newY))

    return False