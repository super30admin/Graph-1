# Runs on Leetcode
    # Runtime - O(m*n) where m, n are # of rows and cols respectively
    # Space - O(1)


class Solution:
    import collections
    def hasPath(self, maze, start, destination):
        if not maze or not start or not destination:
            return False
        
        if start == destination:
            return True

        q = collections.deque([start])
        maze[start[0]][start[1]] = 2
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        while q:
            pop = q.popleft()
            if pop[0] == destination[0] and pop[1] == destination[1]:
                return True
            for direction in directions:
                x = pop[0] + direction[0]
                y = pop[1] + direction[1]
                while 0<=x<len(maze) and 0<= y<len(maze[0]) and (maze[x][y] == 0 or                                 maze[x][y] == 2):
                    x += direction[0]
                    y += direction[1]
                rolled_to_x = x - direction[0]
                rolled_to_y = y - direction[1]
                if maze[rolled_to_x][rolled_to_y] != 2:
                    q.append((rolled_to_x, rolled_to_y))
                    maze[rolled_to_x][rolled_to_y] = 2
        return False
