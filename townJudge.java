class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1)
            return -1;

        int[] inDegree = new int[n + 1];

        for (int[] rel : trust) {
            inDegree[rel[0]]--;
            inDegree[rel[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1)
                return i;
        }

        return -1;
    }
}