// Time Complexity : O(V+E). where V is the number of people, E is the trusted relationships
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We maintain a indegrees array and increment the index if we find a trusted one and decrement if we find a trustee. This count if equals n-1 implies
// that he is trusted by everyone except self and he doesn't trust anybody.

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n + 1];
        for (int[] tr : trust) {
            indegrees[tr[0]]--; //person who trusts
            indegrees[tr[1]]++; //person who gets trusted
        }
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == n - 1) { //trusted by all except self and does't trust anyone
                return i;
            }
        }
        return -1;
    }
}
