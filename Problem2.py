'''
Problem:  The Maze
Time Complexity: O(m*n), where m is rows and n is cols
Space Complexity: O(m*n), for queue
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        applied BFS to get the neighbors of the current cell
        if at any of the stopping find we get destination then return true
        else return false
        neighbors are calculated till the ball stops.
'''

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if len(maze)==0:
            return False
        
        if start == destination:
            return True

        m = len(maze)
        n = len(maze[0])
        dirs=[(0,1), (0, -1), (1,0), (-1, 0)]
        queue = deque()
        queue.append((start[0], start[1]))
        maze[start[0]][start[1]] = 2

        while queue:
            r, c = queue.popleft()
            for d in dirs:
                i = r
                j = c
                while(i>=0 and j >=0 and i<m and j<n and maze[i][j]!=1):
                    i+=d[0]
                    j+=d[1]
                i-=d[0]
                j-=d[1]
                if maze[i][j]!=2:
                    if i == destination[0] and j == destination[1]:
                        return True
                    queue.append((i,j))
                    maze[i][j]=2
        
        return False
        

