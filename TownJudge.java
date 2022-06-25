// Time Complexity :O(V+E) where v is n and E is length of trusts array
// Space Complexity :O(V)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        // decresing count in out and incresing count of in person
        for (int[] tr : trust) {
            int out = tr[0] - 1;
            int in = tr[1] - 1;
            indegree[out]--;
            indegree[in]++;
        }
        // at the end person having exactly n-1 trusts is the town judge
        for (int i = 0; i < n; i++) {
            if (indegree[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}