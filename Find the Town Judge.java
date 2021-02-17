/*
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        if N == 0:
            return -1
        
        # as the nodes are starting from 1 to N
        trusts = [0]*(N+1)
        
        for pair in trust:
            trusts[pair[0]] -= 1
            trusts[pair[1]] += 1
        
        for i in range(1, N+1):
            if trusts[i] ==  N-1:
                return i
        return -1
*/
// Time - O(V+E) where v is vertices and e is edges
// Space - O(V) as array is created
// Logic - array is created and the trust level of node goes down if it trusts anybody and its trust level goes up if anyone trust it so at
// the end the node which will have trust level equal to N-1 will be judge

class Solution {
    public int findJudge(int N, int[][] trust) {
        if (N == 0)
            return -1;
        
        int[] trusts = new int[N+1];
        
        for (int[] p: trust){
            trusts[p[0]] --;
            trusts[p[1]] ++;
        }
        for (int i=1; i<N+1; i++){
            if (trusts[i] == N-1)
                return i;
        }
        return -1;
    }
}
        