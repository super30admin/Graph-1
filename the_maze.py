#BFS Solutions
#We make the visited node as 2
#Then we apply the BFS and if we find the destionation node then we return true
#We iterate thriugh all the directions and check the bounds and 
# if there is not obstacle i.e 1 then we move our pointers
#Then we make the cell as visited

#Time Complexity -> O(m*n)
#Space Complexity -> O(m*n)

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