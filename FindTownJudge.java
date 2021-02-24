// Time Complexity : O(m+N) m = no of values in trust
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Calculate indegree. indegree == N for any element will be the town judge

class Solution {
    public int findJudge(int N, int[][] trust) {

        if(trust == null) return -1;
        int[] indegree = new int[N];

        for(int i = 0; i < trust.length; i++) {
            indegree[trust[i][1]-1]++;
            indegree[trust[i][0]-1]--;
        }

        for(int i = 0; i < N; i++) {
            if(indegree[i] == N-1)
                return i+1;
        }
        return -1;
    }
}
