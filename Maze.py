# TC - O(mn)
# SC - O(mn) => doubtful as to why it is mn
class Solution(object):
    def hasPath(self, maze, start, destination):
        """
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """
        dirs = [(0, -1), (0, 1), (1, 0), (-1, 0)]

        r = start[0]
        c = start[1]

        rows = len(maze)
        cols = len(maze[0])

        queue = deque([(r, c)])
        maze[r][c] = 2

        while(queue):
            curr_r, curr_c = queue.popleft()
            for pos in dirs:
                r = curr_r
                c = curr_c
                while((r >= 0 and r < rows) and (c >= 0 and c < cols) and maze[r][c] != 1):
                    r = r + pos[0]
                    c = c + pos[1]

                r = r - pos[0]
                c = c - pos[1]

                if maze[r][c] != 2:
                    if r == destination[0] and c == destination[1]:
                        return True
                    queue.append([r, c])
                    maze[r][c] = 2

        return False
