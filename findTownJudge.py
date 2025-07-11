"""
Check how much each person is trusted (+1) and how many they trust (-1)
Only the judge will have trust score = n - 1
Others will either trust someone (removing them) or not be trusted enough
"""
"""
Time Complexity - O(t + n) – t = len(trust)
Space Complexity - O(n) – trust score array
"""

class findTownJudge:
    def findJudge(self, n: int, trust: list[list[int]]) -> int:
        trust_score = [0] * (n + 1)

        for a, b in trust:
            trust_score[a] -= 1  
            trust_score[b] += 1 

        for i in range(1, n + 1):
            if trust_score[i] == n - 1:
                return i
        return -1
    
if __name__ == "__main__":
    obj = findTownJudge()
    print(obj.findJudge(3, [[1,3],[2,3]])) 
