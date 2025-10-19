#  Time Complexity : O(m * n)
#  Space Complexity : O(m * n)  
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: We use BFS to solve the problem. We traverse in one direction until we hit the stopping point. We make the stopping point equal to -1 to keep track that it has been visited.       
import collections
class Solution:
    def hasPath(self, maze, start, destination):
        self.dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        self.m = len(maze)
        self.n = len(maze[0])

        q = collections.deque()
        q.append([start[0], start[1]])
        maze[start[0]][start[1]] = -1

        while q:
            curr = q.popleft()
            for dir in self.dirs:
                r = dir[0] + curr[0]
                c = dir[1] + curr[1]

                while r >= 0 and c >= 0 and r < self.m and c < self.m and maze[r][c] != 1:
                    r += dir[0]
                    c += dir[1]

                r -= dir[0]
                c -= dir[1]

                if r == destination[0] and c == destination[1]:
                    return True
                if maze[r][c] != -1:
                    maze[r][c] = -1
                    q.append([r, c])
        return False
    
if __name__ =="__main__":
    maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
    start = [0,4]
    destination = [4,4]

    sol = Solution()
    result = sol.hasPath(maze, start, destination)
    print("Result: ", result) 


