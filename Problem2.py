# BFS Solution: It doesn't return the shortest path but DFS solution return shortest path
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        directions = [(0, -1), (-1, 0), (1, 0), (0, 1)]
        m = len(maze)
        n = len(maze[0])

        q = deque()
        q.append(start)
        visited = set()
        visited.add(tuple(start))

        while q:

            x, y = q.popleft()

            if [x, y] == destination:
                return True

            for dx, dy in directions:
                nx = x + dx
                ny = y + dy

                while 0 <= nx < m and 0 <= ny < n and maze[nx][ny] == 0:
                    nx += dx
                    ny += dy

                nx -= dx
                ny -= dy
                if (nx, ny) not in visited:
                    visited.add((nx, ny))
                    q.append((nx, ny))

        return False

