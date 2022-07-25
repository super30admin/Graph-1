//Time : V+E
//Space : O(V)

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] ind = new int[n];
        for (int[] t : trust) {
            ind[t[0] - 1]--;
            ind[t[1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (ind[i] == n - 1)
                return i + 1;
        }
        return -1;
    }
}