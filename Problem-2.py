'''
    Time Complexity: O(mn(m+n))
    Space Complexity: O(mn)
'''
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = len(maze)
        n = len(maze[0])
        directions = [(0, -1), (-1, 0), (0, 1), (1, 0)]

        if start == destination:
            return True

        queue = deque()
        queue.append(start)
        maze[start[0]][start[1]] = 2

        while len(queue):
            curCell = queue.popleft()

            for dir in directions:
                r = curCell[0] + dir[0]
                c = curCell[1] + dir[1]

                while 0 <= r < m and 0 <= c < n and maze[r][c] != 1:
                    r += dir[0]
                    c += dir[1]

                r -= dir[0]
                c -= dir[1]

                if r == destination[0] and c == destination[1]:
                    return True

                if maze[r][c] != 2:
                    maze[r][c] = 2
                    queue.append([r, c])

        return False

        