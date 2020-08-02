# Time Complexity : O(m + n), where m = trust array size, n = degree array size. 
# Space Complexity :O(n), where n = degree array size. 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def findJudge(self, N, trust):
        if N == 0:
            return -1 
        indegree = [0 for _ in range(N)] # 0 0 0 

        for i in range(len(trust)):
            indegree[trust[i][0]-1] -= 1
            indegree[trust[i][1]-1] += 1
        print(indegree)
        for i in range(len(indegree)):
            if indegree[i] + 1 == N:
                return i + 1
        
        return -1 
                
if __name__ == "__main__":
    s = Solution()
    N = 3
    trust = [[1,3],[2,3],[3,1]]
    print(s.findJudge(N, trust))