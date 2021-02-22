
#Time Complexity: O(max(E,V))
#Space Complexity: O(N)
#Run on Leetcode: Yes
#Any Issues: No


class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        trust_dict = {x: [] for x in range(1, N+1)}
        num_trust = {x: 0 for x in range(1, N+1)}
        
        # Get data from trust lists.
        for trust_list in trust: 
            if trust_list[0] in trust_dict.keys(): 
                trust_dict[trust_list[0]].append(trust_list[1])
                num_trust[trust_list[1]] += 1
        

        # Loop through and find out if a judge exists with the above conditions.
        for key in num_trust.keys(): 
            if num_trust[key] == N - 1 and trust_dict[key] == []: 
                return key
            
        return -1