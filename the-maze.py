# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze or not maze[0]:
            return False
        m, n = len(maze), len(maze[0])
        visited = [[False for _ in range(n)] for _ in range(m)]
        queue = deque()
        queue.append((start[0], start[1]))
        visited[start[0]][start[1]] = True
        directions = [(-1,0), (1,0), (0,-1), (0,1)]
        
        while queue:
            x, y = queue.popleft()
            if [x, y] == destination:
                return True
            for dx, dy in directions:
                nx, ny = x, y
                # Roll the ball until it hits a wall
                while 0 <= nx + dx < m and 0 <= ny + dy < n and maze[nx + dx][ny + dy] == 0:
                    nx += dx
                    ny += dy
                if not visited[nx][ny]:
                    visited[nx][ny] = True
                    queue.append((nx, ny))
        return False
        