class Solution(object):
    # tc : O(n*m) worst case we end up moving to each cell, 
    # sc : O(n*m) recurssive stack space 
    def hasPath(self, maze, start, destination):
        """
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """
        # connected components will be usign dfs approach to reach from the start t the destination 
        # will keep moving in a direction until it hit the obstacal or wall, then we check is this poistion the destination if not we check the 4 directions
        # in the 4 directions we should avoid moving the previous block if not we will end up in a infinite loop
        # so will keep a visited mark on the blocks so thatg we dont go into the same node again

        self.m = len(maze)
        self.n = len(maze[0])
        self.dirs = [[-1,0], [1,0], [0,-1], [0,1]]

        return self.dfs(maze,start[0],start[1],destination)

    def dfs(self,maze,i,j,destination):
        # base condtion 
        if i == destination[0] and j == destination[1]:
            return True

        # if we alredy visited this node then we just keep moving in circles and nevere reaching the destination
        if maze[i][j] == -1: #-1 means the node is already visited
            return False
        
        # if none of the above conditions lets traverse, but first lets mark it visited
        maze[i][j] = -1

        for dir in self.dirs:
            r = dir[0] + i
            c = dir[1] + j 

            while r >=0 and r < self.m and c >= 0 and c < self.n and maze[r][c] != 1: # until we hit the obstcale we should keep moving in that direction
                r += dir[0]
                c += dir[1]
            
            # until the last obstacle we are updating our r and col so the current position should be one behind
            r -= dir[0]
            c -= dir[1]

            if self.dfs(maze,r,c,destination):
                return True
        
        return False 