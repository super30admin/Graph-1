class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        # o(n^2)
        def canCompete(i):
            s=gas[i]-cost[i]
            j = i+1
            if(s<0):
                return -1
            while(j!=i):
                if(j==len(gas)):
                    j=0
                if(j==i):
                    return i
                s = s + gas[j] - cost[j]
                j+=1
                if(s<0):
                    return -1
            
            return i
                
        for i in range(0,len(gas)):
            if(gas[i]>=cost[i]):
                # topological sort, start from indegree
                z = canCompete(i)
                if(z>-1):
                    return z
        
        return -1
