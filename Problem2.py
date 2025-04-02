# In this approach, we use BFS to find the path from start to destination. We mark the visited cells as 2. We keep moving in the direction until we hit a wall. If we reach the destination, we return True. If we exhaust all possibilities, we return False.
# TC: O(m * n)
# SC: O(m * n)


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = len(maze)
        n = len(maze[0])
        if not maze or not maze[0]:
            return False
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        q = deque()
        q.append([start[0], start[1]])
        maze[start[0]][start[1]] = 2
        while q:
            curr = q.popleft()
            if curr == destination:
                return True
            for dir in dirs:
                nr = curr[0] + dir[0]
                nc = curr[1] + dir[1]
                while nr >= 0 and nr < m and nc >= 0 and nc < n and maze[nr][nc] != 1:
                    nr = nr + dir[0]
                    nc = nc + dir[1]
                
                nr = nr - dir[0]
                nc = nc - dir[1]
                if maze[nr][nc] != 2:
                    q.append([nr, nc])
                    maze[nr][nc] = 2

        return False