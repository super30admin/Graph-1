//  Time Complexity: O(n)
//  Space Compexity: O(n)

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] degrees = new int[n+1];

        for (int[] ar : trust) {
            degrees[ar[0]]--;
            degrees[ar[1]]++;
        }

        int count = 0;
        int res = -1;
        for (int i = 1; i <= n; ++i) {
            if (degrees[i] == n-1) {
                count++;
                res = i;
            }
        }

        return count == 1 ? res : -1;
    }
}
