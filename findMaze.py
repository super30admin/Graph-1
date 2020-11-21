"""
Time : O(M*N)
Space : O(M*N)
Leetcode : Yes
Explanation : Do basic BFS and mark each visted node with 2, go to nodes where the value is 0. When you see a path, keep going and stop only
when you see a non one element. When you stop, add last non 1 node to visted and queue.
"""
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # Check for an empty graph.
        if not maze:
            return []
        
        n = len(maze)
        m = len(maze[0])
        
        rows, cols = len(maze), len(maze[0])
        visited = set()
        directions = ((0, 1), (0, -1), (1, 0), (-1, 0))

        queue = deque([(start[0], start[1])])
        visited.add((start[0] , start[1]))
        while queue:
            s = queue.popleft()

            # check if destination reached
            if s[0] == destination[0] and s[1] == destination[1]:
                return True

            for direction in directions:
                
                x = s[0] + direction[0]
                y = s[1] + direction[1]

                # move till you hit something not 1
                while(x >= 0 and x < n and y >= 0 and y < m and maze[x][y] != 1):
                    x += direction[0]
                    y += direction[1]
                
                # only add the end step (x - dir[0] , y - dir[1])
                stop_i = x - direction[0]
                stop_j = y - direction[1]

                if(not (stop_i, stop_j) in visited):
                    visited.add((stop_i, stop_j))
                    queue.append((stop_i, stop_j))
                    
        return False