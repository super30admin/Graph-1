"""
From each position, roll in all directions until hitting a wall
Once stopped, treat that as a new node and explore from there
Use BFS or DFS to traverse and avoid revisiting already stopped positions
"""
"""
Time Complexity - O(m × n) – Each cell visited once
Space Complexity - O(m × n) – For visited and queue
"""

from collections import deque

class theMaze:
    def hasPath(self, maze: list[list[int]], start: list[int], destination: list[int]) -> bool:
        rows, cols = len(maze), len(maze[0])
        visited = set()
        queue = deque([tuple(start)])

        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        while queue:
            r, c = queue.popleft()
            if [r, c] == destination:
                return True

            if (r, c) in visited:
                continue
            visited.add((r, c))

            for dr, dc in directions:
                nr, nc = r, c
                
                while 0 <= nr + dr < rows and 0 <= nc + dc < cols and maze[nr + dr][nc + dc] == 0:
                    nr += dr
                    nc += dc
                queue.append((nr, nc))

        return False

if __name__ == "__main__":
    maze = [
        [0, 0, 1, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 0, 0, 1, 0],
        [1, 1, 0, 1, 1],
        [0, 0, 0, 0, 0]
    ]
    start = [0, 4]
    destination = [4, 4]
    obj = theMaze()
    print(obj.hasPath(maze, start, destination))
