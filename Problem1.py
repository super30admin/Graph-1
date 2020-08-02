class Solution:
    
    """
    
        Name : Shahreen Shahjahan Psyche
        Time : O(N) 
        Space : O(N) 
        
        Passed Test cases in LC : Yes
    
    
    """
    
    
    """
    
        This is an iterative solution where it uses array and a set as an auxialiary data structures
    
    """
    def arraySolution(self, N, trust):
        
        # creating an array to track thee count of people who trusts
        track = [0 for _ in range(N)]
        
        # creating a set to check whether any person is missing who does not trust anyone
        trust_others = set()
        
        for i in trust:
            track[i[1]-1] += 1
            trust_others.add(i[0])
        for i in range(len(track)):
            # if the count is equal to N - 1, that means eveeryonee trusts i except i
            if track[i] == N-1:
                # checking whether i trusts anyone
                if (i+1) not in trust_others:
                    return i + 1
        return -1
        
    """
    
        This is an iterative solution where it uses hashmap and a set as an auxialiary data structures
    
    """
    def hashMapSolution(self, N, trust):
        
        # edge case
        if N == 1:
            return 1
        
        # creating a set to check whether any person is missing who does not trust anyone
        trusts = set()
        # creating a hashmap to track the count of people who trusts
        trusted_by = {}
        
        for i in trust:
            trusts.add(i[0])
            
            if i[1] not in trusted_by.keys():
                trusted_by[i[1]] = []
            trusted_by[i[1]].append(i[0])
            
        for j in trusted_by.keys():
            # if the count is equal to N - 1, that means eveeryonee trusts i except i
            if len(trusted_by[j]) == N-1:
                # checking whether i trusts anyone
                if j not in trusts:
                    return j
        
        return -1
            
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        
        if trust is None:
            return -1
        
        # return self.hashMapSolution(N, trust)
        return self.arraySolution(N, trust)
    
