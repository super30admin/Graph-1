# Time: O(n*m)
# Space: O(n*m)
class Solution(object):
    def __init__(self):
        self.directions = [[0,1], [0, -1], [1, 0], [-1, 0]]
    def hasPath(self, maze, start, destination):
        """
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """
        m, n = len(maze), len(maze[0])
        visited = set() 
        queue = collections.deque([(start[0], start[1])])
        visited.add((start[0], start[1]))
        while queue:
            i, j = queue.popleft()
            if [i,j] == destination:
                return True
            for dx, dy in [(0,1), (0,-1), (1, 0), (-1, 0)]:
                new_x, new_y = i, j
                while 0 <= new_x+dx < m and 0 <= new_y+dy < n and maze[new_x+dx][new_y+dy] == 0:
                    new_x += dx
                    new_y += dy
                if (new_x, new_y) not in visited:
                    visited.add((new_x, new_y))
                    queue.append((new_x, new_y))
        return False
        
        
