#Time Complexity: O(E)

#Space Complexity: O(N) 

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        
        trusting_map = {}
        trusted_by = [0]*(n+1)
        present_judge = 0
        present_judge_index = 1
        for item in trust:
            if item[0] not in trusting_map:
                trusting_map[item[0]] = []
            trusting_map[item[0]].append(item[1])
            trusted_by[item[1]]+=1
            if trusted_by[item[1]] > present_judge:
                present_judge = trusted_by[item[1]]
                present_judge_index = item[1]
        if present_judge==n-1 and present_judge_index not in trusting_map:
            return present_judge_index
        else:
            return -1
            