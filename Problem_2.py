# Time Complexity: O(m * n)
# Space Complexity: O(m * n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
  def hasPath(self, maze, start, destination):
    m = len(maze)
    n = len(maze[0])
    dirs = [0, 1, 0, -1, 0]
    q = collections.deque([(start[0], start[1])])
    seen = {(start[0], start[1])}
    def isValid(x, y):
      return (0 <= x < m) and (0 <= y < n) and (maze[x][y] == 0)
    while q:
      i, j = q.popleft()
      for k in range(4):
        x = i
        y = j
        while isValid((x + dirs[k]), (y + dirs[k + 1])):
          x += dirs[k]
          y += dirs[k + 1]
        if [x, y] == destination:
          return True
        if (x, y) in seen:
          continue
        q.append((x, y))
        seen.add((x, y))
    return False