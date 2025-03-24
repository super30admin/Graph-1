// TC: O(m + n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // imagine as graph, popeple = vertices, trust = edge
    // TC = O(m + n), SC = O(n)
    public int findJudge(int n, int[][] trust) {
        // if(n == 0 || trust == null || trust.length == 0) return -1; // worng as fails the corner case: n = 1, trust = []
        if(n == 0) return -1;
        int[] indegrees = new int[n];
        for(int[] t: trust) {
            indegrees[t[0] - 1]--; // -1 as indegrees is 0 based & represents peopele, -- for trusting
            indegrees[t[1] - 1]++; // ++ for gettign trusted
        }
        for(int i = 0; i < n; i++) {
            if(indegrees[i] == n - 1) { // all trusts i, i trusts no one, people id + 1 as 0 based
                return i + 1;
            }
        }
        return -1;
    }
}