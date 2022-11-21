//Time complexity : O(V+E)
//Space complexity : O(V)
class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 0) return -1;

        int[] result = new int[n];

        for (int[] trustEl: trust) {
            int elShowingTrust = trustEl[0];
            int elGettingTrust = trustEl[1];

            // Add 1 to index = elGettingTrust-1
            result[elShowingTrust - 1]--;

            // Subtract 1 to index = elShowingTrust - 1
            result[elGettingTrust -1]++;
        }

        // Final traversal to find index with value = n -1
        for (int i=0; i <n; i++) {
            if (result[i] == n-1) {
                return i+1;
            }
        }

        return -1;
    }
}

