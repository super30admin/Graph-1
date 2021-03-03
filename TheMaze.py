'''
Time Complexity : O(m*n) 
Space Complexity : O(m*n)- as length of queue increases rapidly and can have max of all at once
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
here, we will use BFS to solve this one. we will put inside the queue all the neighbors and check if its is wall
or not and stop there. If its already visited, we wont do anything, otherwise, we will put that neighbor
inside queue. At the end, if at any point the value taken out of queue equals destination, return True,
otherwise False

'''

from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        if not maze:
            return False
        
        rows = len(maze)
        cols = len(maze[0])
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        
        visited = set()
        
        queue = deque()
        queue.append(tuple(start))
        
        visited.add(tuple(start))
        
        while(queue):
            
            s= queue.popleft()

            if (s[0]==destination[0] and s[1]==destination[1]):
                return True
            
            for dirn in dirs:
                
                x=s[0]+dirn[0]
                y=s[1]+dirn[1]
                
                while (x>=0 and y>=0 and x < rows and y<cols and maze[x][y]==0):
                    x+=dirn[0]
                    y+=dirn[1]
                
                new_x = x-dirn[0]
                new_y = y-dirn[1]
                if (new_x, new_y) not in visited:
                    queue.append((new_x,new_y))
                    visited.add((new_x,new_y))
                    
        return False
