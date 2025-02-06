// T.C -> O(V+E)
// S.C -> O(V)

// Does it pass LC: Yes

// increasing indegree when someone is trusted and decreased when someone trusts
// judge will have indegrees equal to n-1 

class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] indegrees = new int[n + 1];

        for (int[] edge : trust) {
            indegrees[edge[0]]--;
            indegrees[edge[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == n - 1) {
                return i;
            }
        }
        return -1;

    }
}
