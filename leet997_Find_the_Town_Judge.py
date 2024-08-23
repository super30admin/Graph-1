# Solution

# // Time Complexity : O(E+V)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is to go through each edge and store the inbound and outbound weight of each vertex. If a vertex has n-1 as weight then it means
# it has trust from all other vertices and it doesnot trust any other vertex which is the defination of cadidate eligible for Town Judge
# Using an auxilary array for this


def findJudge(n,trust):
    auxArray = [0]*(n+1)

    for edge in trust:
        auxArray[edge[0]] -= 1
        auxArray[edge[1]] += 1
    
    for i in range(1,n+1):
        if auxArray[i] == n-1:
            return i
    
    return -1

if __name__ == "__main__":
    # n = 2
    # trust = [[1,2]]
    n = 3
    # trust = [[1,3],[2,3]]
    trust = [[1,3],[2,3],[3,1]]
    print(findJudge(n,trust))