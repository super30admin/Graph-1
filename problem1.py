#Find the town judge
# // Time Complexity :  O(N+M)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no




def findJudge( n: int, trust) -> int:

    indegrees=[0 ]*(n+1)
    for i in trust:                     #in an array, increment everytime there is an incoming node, decrement if there is outgoing node
        indegrees[i[1]]+=1
        indegrees[i[0]]-=1
    for i,j in enumerate(indegrees):
        if i!=0 and j==n-1:                     #the value that has n-1 in it will be the town judge, 
            return i
    return -1                                   #if not, no one is the judge
    
    