// Time Complexity = O(v+e)
// Space Complexity = O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust == null || n == 0) return -1;
        int[] count = new int[n+1];

        for (int i=0; i < trust.length; i++) {
            count[trust[i][0]]--;
            count[trust[i][1]]++;
        }

        // We iterate from 1 to check which person is the judge
        for (int i=1; i<=n; i++) {
            if (count[i] == n-1) {
                return i;
            }
        }
        return -1;
    }
}