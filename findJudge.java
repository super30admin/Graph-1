// Time Complexity : O(N) 
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class findJudge {
    public int findJudge(int N, int[][] trust) {
        int[] inDegrees = new int[N + 1];
        for (int[] i : trust) {
            inDegrees[i[0]]--;
            inDegrees[i[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (inDegrees[i] == N-1) {
                return i;
            }
        }
        return -1;
    }
}