// TC: O(n)
// SC: O(n)

// Approach: Find indegrees. Town judge will have n - 1 indegrees as
// they are trusted by everyone but does not trust anyone

class TownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n + 1];

        if (n == 1) {
            return 1;
        }

        for (int[] t : trust) {
            indegrees[t[1]]++;
            indegrees[t[0]]--;
        }

        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}