public class TownJudge {
    // TC: O(N) where N is length of trust array
    // SC: n
    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;
        int[] score = new int[n + 1];
        for (int[] t : trust) {
            score[t[0]]--;
            score[t[1]]++;
        }
        for (int i = 0; i < score.length; i++) {
            if (score[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
