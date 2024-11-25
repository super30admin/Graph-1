// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : while optimizing SC to O(n) from O(2n)

/**
 * Intuition:
 * <p>
 * considering the persons as nodes in a graph, for a town judge, indegrees should be = n-1
 * and outdegress should be = 0
 */
public class FindJudge {

    /**
     * TC: O(n)
     * SC: O(2n)
     *
     * @param n
     * @param trust
     * @return
     */
    public int findJudge(int n, int[][] trust) {
        // an optmization
        // since we know, that for a town judge, the indegree should be = n-1
        // i.e. trust[] should have at the least (n-1) edges
        if (trust.length < n - 1) {
            return -1;
        }
        int[] indegrees = new int[n + 1];
        int[] outdegrees = new int[n + 1];
        for (int[] i : trust) {
            int a = i[0];
            int b = i[1];
            indegrees[b]++;
            outdegrees[a]++;
        }
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == n - 1 && outdegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * TC: O(n)
     * SC: O(n)
     *
     * @param n
     * @param trust
     * @return
     */
    public int findJudge_optimized(int n, int[][] trust) {
        // an optmization
        // since we know, that for a town judge, the indegree should be = n-1
        // i.e. trust[] should have at the least (n-1) edges
        if (trust.length < n - 1) {
            return -1;
        }
        /*
         * we know, indegrees should be (n-1) and outdegree should be 0.
         *
         * i.e., maximize indegrees and minimize outdegrees => increment for indegrees and decrement for outdegrees
         */
        int[] degrees = new int[n + 1];
        for (int[] i : trust) {
            int a = i[0];
            int b = i[1];
            degrees[b]++;
            degrees[a]--;
        }
        for (int i = 1; i <= n; i++) {
            if (degrees[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

}
