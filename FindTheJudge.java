// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class FindTheJudge {
    public int findJudge(int n, int[][] trust) {
        int[] map = new int[n];
        // add for inward arrow
        // sub for outward arrow
        for (int[] t : trust) {
            map[t[0] - 1]--;
            map[t[1] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (map[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
