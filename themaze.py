"""490. The Maze
Time Complexity: O(mn)
Space Complexity: O(1)"""
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze==None and len(maze)==0:
            return True
        q = deque()
        q.append(start)
        print(q)
        maze[start[0]][start[1]] = 2
        dirs  = [[0,1],[1,0],[-1,0],[0,-1]]
        
        while q:
            cur = q.popleft()
            for d in dirs:
                i = cur[0]
                j = cur[1]
                while i>=0 and i<len(maze) and j>=0 and j<len(maze[0]) and maze[i][j]!=1:
                    i = i +d[0]
                    j = j +d[1]
                i = i-d[0]
                j = j-d[1]
                if i == destination[0] and j ==destination[1]:
                    return True
                if maze[i][j]!=2:
                    q.append([i,j])
                    maze[i][j] =2
        return False