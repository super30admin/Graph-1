// Time Complexity : O(n + m) where n is the number of people and m is the number of trust relationships
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use an indegree array to track the net trust score of every person.
// If a person trusts someone, their score decreases; if they are trusted by someone, their score increases.
// The town judge will have a score of n-1 because everyone trusts them and they trust nobody.

class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] indegrees = new int[n + 1];

        // build trust scores
        for(int[] t : trust) {
            indegrees[t[0]]--;
            indegrees[t[1]]++;
        }

        // judge should have score n-1
        for(int i = 1; i <= n; i++) {
            if(indegrees[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}