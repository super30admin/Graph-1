
# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        """
        BFS- do DFS later..
            - keep going on next valid spot..
        """
        
        if not maze:
            return False
        dirs = [ [0,1], [1,0], [0,-1], [-1,0]]
        queue = deque([(start[0],start[1])])
        maze[start[0]][start[1]] = -1
        print(maze)
        
        while queue:
            curr = queue.popleft()
            
            if curr[0] == destination[0] and curr[1] == destination[1]:
                return True
            
            for direction in dirs:
                i = curr[0]
                j = curr[1]
                
                while i >= 0 and j >= 0 and i < len(maze) and j < len(maze[0]) and maze[i][j] != 1:
                    i += direction[0]
                    j += direction[1]
                    
                i -= direction[0]
                j -= direction[1]
                
                if maze[i][j] != 2:
                    queue.append([i,j])
                    maze[i][j] = 2
                    
        return False