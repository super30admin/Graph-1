"""
I used BFS to explore all possible paths in the maze, starting from the start position. From each cell, I simulate the ball rolling in all four directions until it hits a wall (not one step at a time). Once it stops, if the position hasn't been visited (marked as 2), I add it to the queue. If we reach the destination, I return True; otherwise, after exploring all possibilities, return False. The visited cells are marked directly in the maze to avoid using extra space.
Time Complexity: O(mn)
Space Compelxity: O(mn)
"""
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m, n = len(maze), len(maze[0])
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        queue = deque()
        
        queue.append(start)
        maze[start[0]][start[1]] = 2

        while queue:
            r, c = queue.popleft()

            if [r, c] == destination:
                return True

            for dx, dy in directions:
                i, j = r, c
                while 0 <= i < m and 0 <= j < n and (maze[i][j] == 0 or maze[i][j] == 2):
                    i += dx
                    j += dy

                i -= dx
                j -= dy

                if maze[i][j] != 2:
                    queue.append([i, j])
                    maze[i][j] = 2 
        return False