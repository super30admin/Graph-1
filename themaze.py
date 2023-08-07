# // Time Complexity :O(nm)
# // Space Complexity :O(nm)
# // Did this code successfully run on Leetcode :Yes 
# // Any problem you faced while coding this :NO
from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], dest: List[int]) -> bool:
        n = len(maze)
        m = len(maze[0])
        visited = [[0 for j in range(m)] for i in range(n)]
        q = deque()
        q.append(start)
        visited[start[0]][start[1]] = 1
        dir1 = [0,0,1,-1]
        dir2 = [1,-1,0,0]
        while(q):
            temp = q.popleft()
            if(temp[0] == dest[0] and temp[1] == dest[1]):
                return True
            for i in range(4):
                x = temp[0] + dir1[i]
                y = temp[1] + dir2[i]
                while(x >= 0 and y >= 0 and x < n and y < m and maze[x][y] == 0):
                    x += dir1[i]
                    y += dir2[i]
                x -= dir1[i]
                y -= dir2[i]
                if(visited[x][y] == 0):
                    q.append((x,y))
                    visited[x][y] = 1
        return False

        
