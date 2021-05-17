class Solution:
    def hasPath(
        self, maze: List[List[int]], start: List[int], destination: List[int]
    ) -> bool:
        if maze is None or len(maze) == 0:
            return false
        dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        m = len(maze)
        n = len(maze[0])
        q = deque()
        q.append((start[0], start[1]))
        while q:
            curr = q.popleft()
            if curr[0] == destination[0] and curr[1] == destination[1]:
                return True
            for dirc in dirs:
                r = curr[0] + dirc[0]
                c = curr[1] + dirc[1]
                while r >= 0 and c >= 0 and r < m and c < n and maze[r][c] != 1:
                    r += dirc[0]
                    c += dirc[1]
                r = r - dirc[0]
                c = c - dirc[1]
                if maze[r][c] != 2:
                    maze[r][c] = 2
                    q.append((r, c))
        return False
