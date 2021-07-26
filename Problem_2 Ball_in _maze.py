# // Time Complexity : O(mn) where m and n are number of rows and columns respectively
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
#BFS Method
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = len(maze)
        n = len(maze[0])
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        q = deque()
        q.append((start[0], start[1]))
        maze[start[0]][start[1]] = 2
        while q:
            curr = q.popleft()
            for d in dirs:
                i = curr[0]
                j = curr[1]
                while i < m and i >= 0 and j >= 0 and j < n and maze[i][j] != 1:
                    #Iterate until there are no obstacles
                    i += d[0]
                    j += d[1]
                #Bring back one step
                i -= d[0]
                j -= d[1]
                if maze[i][j] != 2:
                    #if node is not visited already
                    if i == destination[0] and j == destination[1]:
                        #Check if it is the destination node
                        return True
                    #if not the destination, Add it to the queue and mark it as visited
                    q.append((i, j))
                    maze[i][j] = 2

        return False

# // Time Complexity : O(mn) where m and n are number of rows and columns respectively
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
#DFS
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = len(maze)
        n = len(maze[0])
        return self.dfs(maze, start, destination, m, n)

    def dfs(self, maze, start, destination, m, n):
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        # base
        #If Destination is reached
        if start[0] == destination[0] and start[1] == destination[1]:
            return True
        # logic
        maze[start[0]][start[1]] = 2
        #Iterate in all 4 direction
        for d in dirs:
            i = start[0]
            j = start[1]
            while i < m and i >= 0 and j >= 0 and j < n and maze[i][j] != 1:
                # Iterate until there are no obstacles
                i += d[0]
                j += d[1]
            # Bring back one step
            i -= d[0]
            j -= d[1]
            #If node is not visited
            if maze[i][j] != 2 and self.dfs(maze, [i, j], destination, m, n):
                return True
        return False
