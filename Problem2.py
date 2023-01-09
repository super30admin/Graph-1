#TC: O(m * n)^2
#SC: O(m * n)

#Leetcode premium question

#Approach: Can be solved using DFS or BFS
#Move in one direction until wall hit -> Recurse(add to stack - DFS) or add to queue (BFS) only on a 'stop' node
#Check if stop node is destination node, if yes, return True, else continue popping from queue/stack and iterating in all directions



dirns = [[-1,0],[1,0],[0,-1],[0,1]] #U, D, L, R
def hasPath(self, maze, start, destination):
  return dfs(maze, start, destination)

def dfs(maze, start, destination):
  r = start[0]
  c = start[1]
  #base case
  if maze[r][c] == -1:
    return False
  if r == destination[0] and c == destination[1]:
    maze[r][c] = -1
    return True

  #logic
  #mark as visited
  maze[r][c] = -1
  for dirn in dirns:
    while r >= 0 and r < len(maze) and c >= 0 and c < len(maze[0]) and maze[r][c] != 1:
      r += dirn[0]
      c += dirn[1]
    #now we are standing on wall or boundary
    r -= dirn[0]
    c -= dirn[1]
    #now we are standing on a stop position
    if dfs(maze,[r,c],destination):
      return True
  return False
