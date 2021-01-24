"""
Approach: BFS 

Here we will traverse to every direction from our starting node. Now one of the condition two change the direction here is if encounter a wall. So we will keep traversing in a certain direction until we hit the wall. 

We will also mutate the matrix to keep track of the vistited destinations. If at any point ball encounters a wall we will check if the cell is the destination cell or not. 

So whenver we encounter a wall we mark that cell as 2 and add it to the BFS queue.

[[0,0,1,0,0],
 [0,0,0,0,0],
 [0,0,0,1,0],
 [1,1,0,1,1],
 [0,0,0,0,0]], start = [0,4], destination = [4,4]
 
For above example our queue will look like this

[[0,4]] <- start

[[2,4],[0,3]] <- down from [0,4], wall after [2,4]. Add [2,4] to queue. 
Left from [0,4] wall after [0,3]. Add to queue. Mark [0,4] visited. 

[[0,3]] <- from [2,4] we cannot go left right and down. We go up uptill [0,4] but it is visited so we wont add it to queue. 

[[1,3]]
[[1,4],[1,0]]

And so on...

TC: O(m x n)
SC: O(m x n)

"""

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze == None or len(maze) == 0:
            return False
        
        m = len(maze)
        n = len(maze[0])
        q = [start]
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        maze[start[0]][start[1]] = 2
        while len(q):
            curr = q.pop(0)
            
            if curr[0] == destination[0] and curr[1] == destination[1]:
                return True
            
            for d in dirs:    
                i = curr[0]
                j = curr[1]
                
                while i >= 0 and j >= 0 and i < m and j < n and maze[i][j] != 1:
                    i = i + d[0]
                    j = j + d[1]
                    
                i = i - d[0]
                j = j - d[1]
                
                if maze[i][j] != 2:
                    q.append([i,j])
                    maze[i][j] = 2
                    
                    
        return False
    
    
"""
Approach: DFS


TC: O(m x n)
SC: O(m x n)
"""

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze == None or len(maze) == 0:
            return False
        
        self.m = len(maze)
        self.n = len(maze[0])
        s = [start]
        self.dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        
        return self.dfs(maze, start, destination)
        
    def dfs(self, maze, start, destination):
        if start[0] == destination[0] and start[1] == destination[1]:
            return True
        
        if maze[start[0]][start[1]] == 2:
            return False 
        
        maze[start[0]][start[1]] = 2
        for d in self.dirs:
            i = start[0]
            j = start[1]
        
            while i >= 0 and j >= 0 and i < self.m and j < self.n and maze[i][j] != 1:
                i = i + d[0]
                j = j + d[1]

            i = i - d[0]
            j = j - d[1]
        
            if self.dfs(maze, [i,j], destination):
                return True

        return False
                
        
        