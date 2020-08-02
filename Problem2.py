class Solution:
    
    """
    
        Name : Shahreen Shahjahan Psyche
        Time : BFS : O(MN) [Size of Maze]
               DFS : O(MN)
        Space: BFS : O(MN)
               DFS : O(MN)
               
        Passed Test Cases : Yes
    
    
    """
    
    
    """
        
        This method solves the problem using BFS
        
    
    """
    def methodBFS(self, maze, start, destination):
        
        from collections import deque
        
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        q = deque()
        q.append(start)
        
        
        while q:
            curr = q.popleft()
             # travarsing through 4 directions
            for i in dirs:
                s = [curr[0]+i[0], curr[1]+i[1]]
                flag = True
                # rolling thee ball until it hits a wall
                while flag:
                    if s[0] >= len(maze) or s[1] >= len(maze[0]) or s[0] < 0 or s[1] < 0:
                        break
                    if maze[s[0]][s[1]] == 1:
                        break
                    s[0] += i[0]
                    s[1] += i[1]
                s[0] -= i[0]
                s[1] -= i[1]
                if s[0] == destination[0] and s[1] == destination[1]:
                    return True
                 # if the position is unvisited, then adding to the queue and marking the place as 2
                if maze[s[0]][s[1]] == 0:
                    q.append(s)
                    maze[s[0]][s[1]] = 2
        
        return False
    
    
     
    """
        
        This method solves the problem using DFS
        
    
    """
    def methodDFS(self, maze, start, destination):
        
        # base case
        if start[0] == destination[0] and start[1] == destination[1]:
            return True
        
        # recursive 
        result = False
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        
        # travarsing through 4 directions
        for i in dirs:
            s = [start[0]+i[0], start[1]+i[1]]
            # rolling thee ball until it hits a wall
            while True:
                if s[0] >= len(maze) or s[1] >= len(maze[0]) or s[0] < 0 or s[1] < 0:
                        break
                if maze[s[0]][s[1]] == 1:
                        break  
                s[0] += i[0]
                s[1] += i[1]
            s[0] -= i[0]
            s[1] -= i[1]
            
            # if the position is unvisited, then recusrsing and marking the place as 2
            if maze[s[0]][s[1]] == 0:
                maze[s[0]][s[1]] = 2
                result = result or self.methodDFS(maze, s, destination)
            
        return result
        
        
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        if not maze:
            return False
        
        return self.methodDFS(maze, start, destination)
        
