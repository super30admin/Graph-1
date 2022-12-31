# Time Complexity : O(m+n), Where m,n are number of rows, columns in maze 2d array 
# Space Complexity : O(m+n), Where m,n are number of rows, columns in maze 2d array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific
from typing import List

class Solution:
    def __init__(self):
        self.directions=[[-1,0],[1,0],[0,-1],[0,1]]
        
    def solution(self,actual_array,visted_array,index,destination,m,n):
        #Base Case
        if(index[0]==destination[0] and index[1]==destination[1]):
            return True
        #Actual Logic
        #First let us make the index as visted
        visted_array[index[0]][index[1]]=True
        for i in self.directions:
                r=index[0]
                c=index[1]
                while((r in range(m)) and (c in range(n)) and (actual_array[r][c]!=1)):
                    r=r+i[0]
                    c=c+i[1]
                #This is undoing the last action we did because we are out of bounds 
                r=r-i[0]
                c=c-i[1]
                if(visted_array[r][c]==False):
                    #Which means we have didn't visted this index, Therefore can do the processing at this index
                    if(self.solution(actual_array,visted_array,[r,c],destination,m,n)):
                        return True
        #If Nothing of the four path occurs then return False
        return False
    #This solution is based on DFS
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        #Edge Case 
        if(len(maze)==0):
            return False
        #Actual Logic
        m=len(maze)
        n=len(maze[0])
        #print(m,n)
        visted=[[False for i in range(n)] for j in range(m)]
        return self.solution(maze,visted,start,destination,m,n)