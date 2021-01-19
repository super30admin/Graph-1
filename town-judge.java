// Time - O(N)
// Space - O(N)

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust==null|N==0) {
            return -1;
        }
        
        int[] indegree = new int[N];
        for(int[] trusts : trust) {
            indegree[trusts[0] - 1]--;
            indegree[trusts[1] - 1]++;
        }
        
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i] == N - 1) {
                return i+1;
            }
        }
        
        return -1;
    }
}
