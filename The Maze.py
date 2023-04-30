class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # BFS APPROACH
        # Time Complexity: O(n*m)
        # Space Complexity: O(n*m)
        #        Top  Bottom  Left  Right
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        rowlen = len(maze)
        collen = len(maze[0])
        visited = set()
        dq = deque()
        dq.append(start)

        while dq:
            r, c = dq.popleft()
            # Base condition
            if r == destination[0] and c == destination[1]: return True
            if maze[r][c] == -1: continue

            maze[r][c] = -1

            # Logic
            for dirr in dirs:
                nr = r + dirr[0]
                nc = c + dirr[1]
                while (0 <= nr and nr < rowlen and 0 <= nc and nc < collen) and maze[nr][nc] != 1:
                    # print(nr, nc)
                    nr += dirr[0]
                    nc += dirr[1]
                # One step back
                nr -= dirr[0]
                nc -= dirr[1]
                dq.append([nr, nc])
        return False



