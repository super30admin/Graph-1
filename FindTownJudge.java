// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n];
        for (int[] t : trust) {
            in[t[0] - 1]--;
            in[t[1] - 1]++;
        }
        for (int i = 0; i < in.length; i++) {
            if (in[i] == n - 1)
                return i + 1;
        }
        return -1;
    }
}