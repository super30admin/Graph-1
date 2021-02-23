# Time Complexity : O(M*N)
# Space Complexity : O(M*N)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I go to all 4 directions until I reach a wall. When I reach a wall I insert that index to a priority queue and then pop to do BFS with all the paths
# in the next level. If the target goes in the queue then return true else if queue becomes empty return False.

from collections import deque
from heapq import heappush, heappop
import time
class Block:
    def __init__(self, x, y, di, dj):
        self.x = x
        self.y = y
        self.score  = math.sqrt(abs(x-di)**2 + abs(y-dj)**2) 
        
    def __eq__(self, other):
        return self.score == other.score
    
    def __lt__(self, other):
        return self.score < other.score
    
    def __gt__(self, other):
        return self.score > other.score
    
    def __le__(self, other):
        return self.score <= other.score 
    
    def __ge__(self, other):
        return self.score >= other.score 

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        self.dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        self.rows = len(maze)
        self.columns = len(maze[0])
        #q = deque()
        q = []
        #q.append(start)
        heappush(q, Block(start[0], start[1], destination[0], destination[1]))
        elements = 1
        while len(q):
            #current = q.popleft()
            current = heappop(q)
            elements+=1
            for direction in self.dirs:
                #i, j = current[0], current[1]
                i, j = current.x, current.y
                while i>=0 and j>=0 and i<self.rows and j<self.columns and maze[i][j]!=1:
                    i+=direction[0] 
                    j+=direction[1]
                    
                i-=direction[0]
                j-=direction[1]
                
                if i == destination[0] and j == destination[1]:
                    print("Steps ", elements)
                    return True
                
                if maze[i][j] != 2:
                    maze[i][j] = 2
                    #q.append([i, j])
                    heappush(q, Block(i, j, destination[0], destination[1]))
        print("Steps ", elements)
        return False
