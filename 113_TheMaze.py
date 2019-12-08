# Leetcode(490)
# time - O(M*N)
# space - O(M*N)
# Using the DFS or BFS approach.
class Solution:
    def hasPath(self, maze, start, destination) -> bool:
        n = len(maze)
        m = len(maze[0])

        visited = [[False for i in range(m)]for j in range(n)]
        queue = []
        queue.append(start)

        while(queue):
            front = queue.pop(0)

            starti = front[0]
            startj = front[1]

            if starti == destination[0] and startj == destination[1]:
                return True

            if visited[starti][startj]: # go to next iteration
                continue;

            visited[starti][startj] = True # if not visited previously the mark it visited

            # Move Down
            tempi = starti
            tempj = startj
            while self.valid(tempi +1, tempj, maze, n, m):
                tempi += 1
            queue.append([tempi,tempj])

            # Move Up
            tempi = starti
            tempj = startj
            while self.valid(tempi - 1, tempj, maze, n, m):
                tempi -= 1
            queue.append([tempi, tempj])

            # Move left
            tempi = starti
            tempj = startj
            while self.valid(tempi, tempj - 1, maze, n, m):
                tempj -= 1
            queue.append([tempi, tempj])

            # Move right
            tempi = starti
            tempj = startj
            while self.valid(tempi, tempj + 1, maze, n, m):
                tempj += 1
            queue.append([tempi, tempj])

    def valid(self, i, j, maze, n, m):
        if i<0 or i>=n or j<0 or j>=m or maze[i][j] == 1: # is there a wall?
            return False
        return True

sol = Solution()
maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
start = [0,4]
dest = [0,1]
print(sol.hasPath(maze, start, dest))

