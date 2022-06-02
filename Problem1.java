public class Problem1 {
    //TC : O(n)
    //SC : O(n)
    public int findJudge(int n, int[][] trust) {
        if (n == 0) return -1;

        int[] inDegrees = new int[n];

        for (int[] t : trust) {
            inDegrees[t[0] - 1]--;
            inDegrees[t[1] - 1]++;
        }

        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
