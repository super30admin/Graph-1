# S30 Problem #116  The Maze
#LeetCode #490 https://leetcode.com/problems/the-maze/description/

# Author : Akaash Trivedi
# Time complexity = O(k * m*n) k is constant so TC~ O(m*n) 
# space complexity = O(m*n)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# BFS solution
# Question clarification: ball has to stop at destination
# add point to queue when ball hits an edge or obstacle, mark it visitied (make it 2)
# So if point is visited then we dont have to explore it again
# check if the point in queue is the destination, then return true

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = len(maze)
        n = len(maze[0])
        # direction up, right, down, left
        dirc = [(0,1),(1,0),(0,-1),(-1,0)]
        r = start[0]
        c = start[1]
        queue = deque()
        queue.append((r,c))
        maze[r][c] = 2
        while queue:
            top= queue.popleft()
            r = top[0]
            c = top[1]
            # reached destination
            if r == destination[0] and c == destination[1]:
                return True
            for dr,dc in dirc:
                nr = r
                nc = c

                while nr >= 0 and nc >=0 and nr < m and nc < n and maze[nr][nc] != 1:
                    # roll the ball till it reached the end
                    nr += dr
                    nc += dc
                
                #roll it one step back
                nr -= dr
                nc -= dc
                if maze[nr][nc] != 2:
                    queue.append((nr,nc))
                    maze[nr][nc] = 2
        return False