//Time complexity: O(|E|), number of edges in the graph.
//Space complexity: O(N)

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length < n-1) return -1;
        
        int[] degree = new int[n+1];
        
        for(int[] t: trust) {
            degree[t[0]]--;
            degree[t[1]]++;
        }
        
        for(int i=1; i<=n; i++) {
            if(degree[i] == n-1) return i;
        }
        return -1;
    }
}