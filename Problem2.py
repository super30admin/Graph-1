"""
1. DFS - stack; the ball needs to move until the wall is reached.
2. Maintain a seen set to keep track of the prev places visited.
3. Backtrack at each point when the wall is reached to reset the ball's position. Add to stack and seen if not visited.
4. After each backtrack, check if the ball is in destination. If yes, return true. Once all possible positions are visited with destination not found we return False.

TC: O(mn) -> Worst case all cells maybe visited
SC: O(mn) -> When all cells are visited and added to seen
"""

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        dirs = [(0,1),(0,-1),(-1,0),(1,0)]
        
        m,n = len(maze), len(maze[0])
        stack = []
        seen = set()

        r,c = start[0], start[1]

        stack.append((r, c))
        seen.add((r, c))

        while stack:
            cur_r, cur_c = stack.pop() 
            for dir in dirs:
                nr = cur_r
                nc = cur_c
                while nr < m and nr >= 0 and nc < n and nc >= 0 and maze[nr][nc] != 1:
                    nr = nr + dir[0]
                    nc = nc + dir[1] 
                nr = nr - dir[0]
                nc = nc - dir[1]
                if [nr, nc] == destination:
                    return True
                if (nr, nc) not in seen:
                    stack.append((nr, nc))
                    seen.add((nr, nc))     
        return False