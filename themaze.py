#Space:O(m*n)
#Time:O(m*n)
from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        queue = deque()
        visited = set()
        if start == destination:
            return True
        destination = tuple(destination)
        queue.append(tuple(start))
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        while(queue):
            curr_point_x,curr_point_y = queue.popleft()
            visited.add((curr_point_x,curr_point_y))
            if (curr_point_x,curr_point_y) == destination:
                return True
            for direction_x,direction_y in dirs:
                new_point_x,new_point_y = curr_point_x+direction_x,curr_point_y+direction_y
                while(0<=new_point_x<len(maze) and 0<=new_point_y<len(maze[0]) and maze[new_point_x][new_point_y]==0) and  :
                    new_point_x+=direction_x
                    new_point_y+=direction_y
                    
                new_point_x-=direction_x
                new_point_y-=direction_y

                if  maze[new_point_x][new_point_y]==0 and (new_point_x,new_point_y) not in visited:
                    queue.append((new_point_x,new_point_y))
        return False