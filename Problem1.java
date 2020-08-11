// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust == null) return -1;
        
        int[] indegree = new int[N+1];
        
        //[-1, 0, 1]
        for(int[] pair: trust){
            indegree[pair[0]]--;
            indegree[pair[1]]++;
        }
        
        for(int i=1; i<N+1; i++){
            if(indegree[i]==N-1)
                return i;
        }
        
        return -1;
    }
}