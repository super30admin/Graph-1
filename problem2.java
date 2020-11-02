class Solution {
    public int findJudge(int N, int[][] trust) {

        if (trust.length < N - 1)
            return -1;
        int[] trustscore = new int[N + 1];

        for (int[] relation : trust) {
            trustscore[relation[0]]--;
            trustscore[relation[1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (trustscore[i] == N - 1)
                return i;
        }
        return -1;
    }
}

// Time:O(N)
// Space:O(N)