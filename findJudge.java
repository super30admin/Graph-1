//https://leetcode.com/problems/find-the-town-judge/
//Time complexity : O(N+E) 
//Space complexity : O(1)
class Solution {
    public int findJudge(int N, int[][] trust) {
        int indegree[] = new int[N];
        for (int t[] : trust) {
            indegree[t[0] - 1]--;
            indegree[t[1] - 1]++;
        }
        for (int i = 0; i < N; i++) {
            if (indegree[i] == N - 1)
                return i + 1;
        }
        return -1;
    }
}
