class Solution:
    def hasPath(self, maze, start, destination):

        m = len(maze)
        n = len(maze[0])
        visited = [[0]*n for _ in range(m)]

        dirX = [-1, 0, 1, 0]
        dirY = [0, 1, 0, -1]

        que = deque()
        que.append(start)

        while que:
            curr = que.popleft()
            visited[curr[0]][curr[1]] = -1

            
            for i in dirX:
                if i == 0:
                    continue

                curr_row = curr[0]
                curr_col = curr[1]

                while 0 <= curr_row + i < m and maze[curr_row + i][curr_col] == 0:
                    curr_row += i

                if [curr_row, curr_col] == destination:
                    return True

                if visited[curr_row][curr_col] != -1:
                    que.append([curr_row, curr_col])
                    visited[curr_row][curr_col] = -1

            
            for j in dirY:
                if j == 0:
                    continue

                curr_row = curr[0]
                curr_col = curr[1]

                while 0 <= curr_col + j < n and maze[curr_row][curr_col + j] == 0:
                    curr_col += j

                if [curr_row, curr_col] == destination:
                    return True

                if visited[curr_row][curr_col] != -1:
                    que.append([curr_row, curr_col])
                    visited[curr_row][curr_col] = -1

        return False