class Solution:
    """
    TC: O(n*m)
    SC: O(n+m)
    where n = number of rows of maze and m = number of columns of maze
    """
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if start[0] == destination[0] and start[1] == destination[1]:
            return True
        
        return self.dfs(maze, destination, start[0], start[1])
        
        
    def dfs(self, maze, dest, i, j):
        directions = [[1,0], [0,1], [-1,0], [0,-1]]
        # check if the current indexes are equal
        if i == dest[0] and j == dest[1]:
            return True
        
        # mark the node as visited
        maze[i][j] = 2
        
        # check in all the four directions
        for dir in directions:
            r = i + dir[0]
            c = j + dir[1]
        
            # check if the wall is reached or not
            while(r >= 0 and r < len(maze) and c >= 0 and c < len(maze[0]) and maze[r][c] != 1):
                r += dir[0]
                c += dir[1]
                
            # if the wall is hit then go back to prev valid position
            r -= dir[0]
            c -= dir[1]
        
            # check for visited nodes and check other valid positions
            if maze[r][c] != 2 and self.dfs(maze, dest, r, c):
                return True
        # return false if all of the above conditions are not satisfied
        return False
        
        