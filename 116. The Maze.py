#Time Complexity: O(mxn)
#Space Complexity: O(mxn)

#--------------------------------------------DFS-------------------------------------------------
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze is None: return False
        dirs = [[0,1], [1,0], [0,-1], [-1,0]]
        return self.helper(maze, start, destination, dirs)
        
    def helper(self, maze, start, destination, dirs):
        #base
        if start == destination: return True
        if maze[start[0]][start[1]] == 2: return False
            
        #logic
        maze[start[0]][start[1]] = 2
        for x in dirs:
            nr = start[0]
            nc = start[1]
            while nr>=0 and nr<len(maze) and nc>=0 and nc<len(maze[0]) and maze[nr][nc] != 1:
                nr += x[0]
                nc += x[1]
            nr -= x[0]
            nc -= x[1]
            if self.helper(maze, [nr,nc], destination, dirs):
                return True
                
        return False   

#--------------------------------------------BFS-------------------------------------------------
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze is None: return False
        queue = []
        dirs = [[0,1], [1,0], [0,-1], [-1,0]]
        queue.append(start)
        maze[start[0]][start[1]] = 2
        while queue:
            index = queue.pop(0)
            if index[0] == destination[0] and index[1] == destination[1]:
                return True
            for x in dirs:
                nr = index[0]
                nc = index[1]
                while nr>=0 and nr<len(maze) and nc>=0 and nc<len(maze[0]) and maze[nr][nc] != 1:
                    nr += x[0]
                    nc += x[1]
                nr -= x[0]
                nc -= x[1]
                if maze[nr][nc] != 2:
                    queue.append([nr, nc])
                    maze[nr][nc] = 2
        return False