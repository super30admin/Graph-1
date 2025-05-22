// Time Complexity: O(E)
// Space Complexity: O(N)
/**
 * Uses two arrays to track in-degree and out-degree for each person.  
 * Iterates through trust pairs to update counts, then scans for the person trusted by all and trusting none.  
 * Efficiently identifies the judge in O(E) time and O(N) space.  
 */
// https://leetcode.com/problems/find-the-town-judge/



class TownJudge {
    public int findJudge(int n, int[][] trust) {

        if (trust.length < n - 1) {
            return -1;
        }

        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];

        for (int[] relation : trust) {
            inDegree[relation[1]]++;
            outDegree[relation[0]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
