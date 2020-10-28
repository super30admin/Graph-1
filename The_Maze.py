# Time - O(m*n)
# Space - O(m*n) - visited set
# usinhg DFS and maintaining a visited set of already visited places.


class Solution:
    
    
    
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        if not maze or len(maze) == 0:
            return False
            
        nRows = len(maze)
        nCols = len(maze[0])
        dirs = [[0,1], [1,0], [-1,0], [0,-1]]
        visited = set()
        
        #return self.helper(maze, start, destination, visited)
        
        def helper(start, visited):

            row = start[0]
            col = start[1]

            if tuple(start) in visited:
                return False

            if (start == destination):
                return True

            visited.add(tuple(start))

            for dir in dirs:
                r = row 
                c = col 

                while(r>=0 and r<len(maze) and c>= 0 and c<len(maze[0]) and maze[r][c] == 0):
                    r += dir[0]
                    c += dir[1]

                if (helper([r-dir[0], c-dir[1]], visited)):
                    return True

            return False
        
        return helper(start, visited)
