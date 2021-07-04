# Time Complexity : O(M*N) (Where M is no of rows and N is no of column in maze)
# Space Complexity : O(M*N)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - This can be solved using bfs and dfs both, I'm using bfs here.
# - Keep visited array to mark visited cell. Add starting point in queue and mark it as visited.
# - Traverse till queue is not empty. Pop cell and see if it is destination. Go to all 4 direction from popped cell. 
# - While moving in one direction check if cell is in the boundary and not hitting the wall.
# - After getting last cell in any direction, if cell is not viisted add it to the queue.

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        maxr = len(maze)
        maxc = len(maze[0])
#       Create visited matrix with False value for each cell.
        visited = [[ False for _ in range(maxc)] for _ in range(maxr) ]
#       Store direction as tuple for easy iterating.
        direction = ((0, -1), (0, 1), (1, 0), (-1, 0))
        
#       Initialize queue and add start cell in it. Also mark it as visited.
        queue = []
        queue.append(start)
        visited[start[0]][start[1]] = True
#       Iterate till queue is empty
        while queue:          
#           Pop the cell from queue and check that the cell is destination or not
            current = queue.pop(0)
            if current[0] == destination[0] and current[1] == destination[1]:
                return True
#           Start with one direction
            for direct in direction:
#               update current location according to direction and check that it is in the boundary and also not hitting the wall
                x, y = current[0] + direct[0], current[1] + direct[1]
                while (0 <= x < maxr) and (0 <= y < maxc) and (maze[x][y] == 0):
                    x += direct[0]
                    y += direct[1]
#               While loop is exited after breaching boundary condition or hitting wall so we need to go back one step in the same direction.
                x -= direct[0]
                y -= direct[1]
#               If cell is not visited add it to the queue and mark it as visited.
                if not visited[x][y]:
                    queue.append([x, y])
                    visited[x][y] = True
#       In the end return false.    
        return False
