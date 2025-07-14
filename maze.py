"""
Approach:
- Use BFS to explore the maze from the start position.
- At each direction (up, down, left, right), roll the ball until it hits a wall.
- From the stopped position, continue BFS if not already visited.
- If at any point the destination is reached, return True.
- Otherwise, return False.

Time Complexity: O(m * n), where m = rows, n = columns
- Each cell is visited at most once.

Space Complexity: O(m * n) for visited set and queue
"""
from collections import deque
class Solution:
    def has_path(self, maze, start, destination):
        # write your code here
        m, n = len(maze), len(maze[0])
        queue = deque()
        queue.append(start)
        maze[start[0]][start[1]]
        visited = set()
        visited.add(tuple(start))
        while queue:
            x, y = queue.popleft()
            for dx, dy in [[-1,0], [1,0], [0,-1], [0,1]]:
                rx, ry = x, y
                nx, ny = rx+dx, ry +dy
                while nx >= 0 and nx < m and ny >= 0 and ny < n and maze[nx][ny] == 0:
                    nx += dx
                    ny += dy
                nx -= dx
                ny -= dy
                if [nx, ny] == destination:
                    return True
                if (nx, ny) not in visited:
                    visited.add((nx,ny))
                    queue.append((nx, ny))
        return False

def main():
    sol = Solution()
    maze = [
        [0, 0, 1, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 0, 0, 1, 0],
        [1, 1, 0, 1, 1],
        [0, 0, 0, 0, 0]
    ]
    start = [0, 4]
    destination = [4, 4]

    result = sol.has_path(maze, start, destination)
    print(f"Has path from {start} to {destination}? {'Yes' if result else 'No'}")


if __name__ == "__main__":
    main()
