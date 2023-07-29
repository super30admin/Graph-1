#Time complexity is: O(mxn)
#Space complexity is: O(mxn)
#No issues faced while coding
#Code ran successfully
from collections import deque
class Solution:
    """
    @param maze: the maze
    @param start: the start
    @param destination: the destination
    @return: whether the ball could stop at the destination
    """
    def has_path(self, maze, start, destination):
        # write your code here
        if(maze==None):
            return False
        #initializing all the requred variables
        m=len(maze)
        n=len(maze[0])
        #Base condition
        if(start[0]==destination[0] and start[1]==destination[1]):
            return True
        #Creating a queue
        q=deque()
        #Initializing the directions array
        dirs=[[-1,0],[1,0],[0,-1],[0,1]]
        #Appending the initial position into the array and updating the value to 2
        q.append(start)
        maze[start[0]][start[1]]=2
        while(len(q)):
            #Popping the values from the queue
            curr=q.popleft()
            #Going through all the directions from the popped queue value
            for dire in dirs:
                i=curr[0]
                j=curr[1]
                #We will be looping through the same direction until the below condition in maze is not satisfied
                while(i<m and j<n and i>=0 and j>=0 and maze[i][j]!=1):
                    i+=dire[0]
                    j+=dire[1]
                #going one step back
                i-=dire[0]
                j-=dire[1]
                #If the maze is not visited, we will check that with destination indexes
                if(maze[i][j]!=2):
                    #If the condition satisfies, we will return Ture
                    if(i==destination[0] and j==destination[1]):
                        return True
                    #Otherwise we will append that to the queue 
                    q.append([i,j])
                    #We will update the maze value to 2
                    maze[i][j]=2
        #We will returning False, if ball doesn't stop at the destinatiion
        return False