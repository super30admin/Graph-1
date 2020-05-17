"""
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""

from collections import deque
        
class Solution:
    def hasPath(self, maze, start: List[int], destination: List[int]) -> bool:
        """
        BFS - boon approach
        - Add the start to queue
        - While queue is not empty
            if front of queue matches dest - return true

            - Roll the position from all the directions until you hit the wall or out of bounds
            - Get the original position before you hit the wall(Backtrack)
            - Check if the position before wall is not visited
                - Mark visited by updating value to 2
                - Add the position to queue

        - return false
        """
        
        maze_q = deque([start])
        while maze_q:
            #get the current position
            curr_pos = maze_q.popleft()
            print(curr_pos)
            if curr_pos == destination:
                return True
            
            directions = [[0,1],[1,0],[-1,0],[0,-1]]
            for d in directions:
                #new_dir = curr_pos + d
                i = curr_pos[0]
                j = curr_pos[1]
                
                #roll the ball by updating the pos till it reaches wall or out of bounds
                while 0 <= i < len(maze) and 0 <= j < len(maze[0]) and maze[i][j] !=1:
                    i += d[0]
                    j += d[1]
            
                #get back the original position before hitting the wall
                i -= d[0]
                j -= d[1]

                #check if not visited
                if maze[i][j] !=2:
                    #mark visited
                    maze[i][j] = 2
                    #add only the valid pos to queue
                    maze_q.append([i,j])
        return False