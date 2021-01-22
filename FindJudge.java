/** Find the Town Judge. If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1. */
// TC O(V+E) SC O(V)
class Solution {
    public int findJudge(int N, int[][] trust) {
        if (N == 0) {
            return -1;
        }
        int [] indeg = new int[N];
        for (int [] trusts : trust) {
            indeg[trusts[0] - 1]--;
            indeg[trusts[1] - 1] ++;
        }
        for (int i = 0; i< N; i ++) {
            if (indeg[i] == N-1){
                return i+1;
            }
        }
        return -1;
    }
}
