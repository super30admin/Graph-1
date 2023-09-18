// Time Complexity: O(V+E)
// Space Complexity: O(V)


class Solution1 {
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n];
        for(int[] e: trust) {
            degree[e[0]-1]--;
            degree[e[1]-1]++;
        }
        for(int i = 0; i < degree.length; i++) {
            if( degree[i] == (n-1)) {
                return (i+1);
            }
        }
        return -1;
    }
}