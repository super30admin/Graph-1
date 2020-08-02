# Time Complexity : O(mxn)
# Space Complexity :O(mxn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    # BFS approach.
    # Time : O(mxn) | Space :O(mxn)
    # def hasPath(self, maze, start, destination):  
    #     if len(maze) == 0 or not maze:
    #         return False

    #     n = len(maze)
    #     m = len(maze[0])
    #     dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    #     q = [start]
    #     maze[start[0]][start[1]] = 2

    #     while len(q) > 0:
    #         curr = q.pop(0)
    #         if curr[0] == destination[0] and curr[1] == destination[1]:
    #             return True
    #         for dir in dirs:
    #             r = curr[0]
    #             c = curr[1]
    #             while r >= 0 and r < n and c >= 0 and c < m and maze[r][c] != 1:
    #                 r += dir[0]
    #                 c += dir[1]
    #             r -= curr[0]
    #             c -= curr[1]
    #         if maze[r][c] != 2:
    #             maze[r][c] = 2
    #             q.append([r, c])

    #     return False

    # DFS Approach.
    # Time : O(mxn) | Space :O(mxn)
    dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    def hasPath(self, maze, start, destination):
        if len(maze) == 0 or not maze:
            return False 
        return self.dfs(maze, start, destination)

    def dfs(self, maze, start, destination):
        # base 
        if start[0] == destination[0] and start[1] == destination[1]:
            return True         
        #logic 
        for dir in self.dirs:
            r = start[0]
            c = start[1]
            while r >= 0 and c >= 0 and r < len(maze) and c < len(maze[0]) and maze[r][c] != 1 :
                r += dir[0]
                c += dir[1]
            r -= dir[0]
            c -= dir[1]
            if maze[r][c] != 2:
                maze[r][c] = 2 
                if self.dfs(maze,[r,c], destination):
                    return True 
        return False
 
if __name__ == "__main__":
    s = Solution()
    maze = [[0, 0, 1, 0, 0],
            [0, 0, 0, 0, 0],
            [0, 0, 0, 1, 0],
            [1, 1, 0, 1, 1],
            [0, 0, 0, 0, 0]]

    start = [0, 4]
    destination = [3, 2]
    print(s.hasPath(maze, start, destination))
