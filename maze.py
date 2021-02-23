class Solution:  
  
    """
    Description: Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination
    
    Time Complexity: O(mn)
    Space Complexity: O(mn)
    
    Approach: BFS:
    - start a queue with starting position in maze and convert the value to -1 (meaning visited)
    - pop first item from the queue and check if it reaches destination, return True if yes
    - with each element of queue move in all 4 direction until a wall or 1 is found, move back the ball to a step before
    - if the position is visited (-1), skip otherwise add in queue and update its value by -1
    - loop until the queue is empty, return False at the end
    """
    
    def hasPath(self, maze, start, destination):

          # write your code here

          if maze == None: return False

          dirs = [(-1,0), (0,1), (1,0), (0,-1)]
          m = len(maze); n = len(maze[0])

          from collections import deque
          queue = deque()

          queue.append(start)
          maze[start[0]][start[1]] = -1

          while queue:
              curr = queue.popleft()
              if curr[0] == destination[0] and curr[1] == destination[1]: return True
              for d in dirs:
                  i = curr[0]; j = curr[1]
                  while i >= 0 and j >= 0 and i < m and j < n and maze[i][j] != 1:
                      i += d[0]; j += d[1]
                  i -= d[0]; j -= d[1]
                  if maze[i][j] != -1:
                      queue.append((i, j))
                      maze[i][j] = -1

          return False
