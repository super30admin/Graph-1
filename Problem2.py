#I used the DFS approach to explore all possible paths from the start position to the destination. The function hasPath initiates the DFS from the starting position and recursively explores all directions (up, down, left, right) by rolling in each direction until hitting a wall. This ensures that the search covers all possible paths in the maze. To avoid revisiting nodes, I use a visited set. If the destination is reached during the search, the function returns True; otherwise, it continues until all possible paths are explored. The time complexity of this approach is O(m * n * (m + n)), where m and n are the dimensions of the maze, due to the nested loops and recursive DFS calls. The space complexity is O(m * n) due to the storage of the visited set and recursion stack.

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m, n = len(maze), len(maze[0])
        destination = tuple(destination)
        visited = set()
        def dfs(v):
            if v in visited: return False
            if v == destination: return True
            visited.add(v)
            i,j = v 
            res = False
            for di, dj in [[-1,0],[1,0],[0,-1],[0,1]]:
                for k in range(max(m,n)):
                    if 0<=i+k*di<m and 0<=j+k*dj<n:
                        if maze[i+k*di][j+k*dj] == 0:
                            nxti, nxtj = i+k*di, j+k*dj
                        else: break
                    else: break
                res = res or dfs((nxti, nxtj))
            return res 
        return dfs(tuple(start))
            