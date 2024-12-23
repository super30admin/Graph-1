class Solution:
    def hasPath(
        self, maze: List[List[int]], start: List[int], destination: List[int]
    ) -> bool:
        directions = [[1, 0], [-1, 0], [0, -1], [0, 1]]
        rows = len(maze)
        cols = len(maze[0])
        visited = [[False] * cols for _ in range((rows))]

        queue = deque([start])
        visited[start[0]][start[1]] = True
        while queue:
            x, y = queue.popleft()
            if [x, y] == destination:
                return True

            for dx, dy in directions:
                new_x, new_y = x, y

                while (
                    0 <= new_x + dx < rows
                    and 0 <= new_y + dy < cols
                    and maze[new_x + dx][new_y + dy] == 0
                ):
                    new_x += dx
                    new_y += dy
                if not visited[new_x][new_y]:
                    visited[new_x][new_y] = True
                    queue.append((new_x, new_y))
        return False

    # time complexity is O(m*n)
    # space complexity is O(m*n)
