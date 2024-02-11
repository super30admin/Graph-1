// Time Complexity : O(V+E)
// Space Complexity : O(V)
class TownJudge {
    public static void main(String[] args) {
        int n = 3;
        int[][] trust = { { 1, 3 }, { 2, 3 } };
        int townJudge = findJudge(n, trust);
        System.out.println(townJudge);
    }

    private static int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1)
            return -1;
        int[] inDegrees = new int[n];
        for (int[] relation : trust) {
            inDegrees[relation[0] - 1]--;
            inDegrees[relation[1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == n - 1)
                return i + 1;
        }
        return -1;
    }

}