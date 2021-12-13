# 490. The Maze
# https://leetcode.com/problems/the-maze/

# Logic: We apply a variuation of BFS. Rather then just adding 
# the neighbouring nodes, we keep on exploring all the possible 
# nodes in the direction of the neighbours till we hit out of 
# bounds or a wall. The place we stop acts as a child node to 
# the parent and gets added to the queue. Before adding it we 
# check if it is the destination, if it is, we return true else 
# continue. After the q is empty, we return false.


# Time Complexity: O(n*m(m+n))
# Space Complexity: O(n*m)

from collections import deque

class Solution:
    def hasPath(self, maze, start, dest):
        n = len(maze)
        m = len(maze[0])

        q = deque()
        
        q.append(start)
        maze[start[0]][start[1]] = 2
        
        dirs = ((0,-1),(0,1),(-1,0), (1,0))
        
        while q:
            row, col = q.popleft()
            
            for _dir in dirs:
                newRow = row
                newCol = col
                
                while 0 <= newRow < n and 0 <= newCol < m and maze[newRow][newCol] != 1:
                    newRow += _dir[0]
                    newCol += _dir[1]
                
                newRow -= _dir[0]
                newCol -= _dir[1]

                if (newRow, newCol) == (dest[0], dest[1]):
                    return True
                
                if maze[newRow][newCol] != 2:
                    maze[newRow][newCol] = 2
                    q.append((newRow, newCol))

        return False