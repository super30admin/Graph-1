// Time Complexity : O(m+ n) m = edges n = nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {

    // approch 1 using indegrees array
    public static int findJudge(int n, int[][] trust) {
        // indegree array
        int[] inD = new int[n];
        // loop through trust array
        for (int[] t : trust) {
            // if x -> y (x trust y) increase count of index y-1 by 1 and
            // decrease count of index x-1 by 1;
            inD[t[0] - 1]--;
            inD[t[1] - 1]++;
        }
        // in second pass we check if any index's count is n-1 we return this index
        // else we retuen -1;
        for (int i = 0; i < inD.length; i++) {
            if (inD[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust = new int[][] {
                { 1, 3 },
                { 2, 3 }
        };
        int n = 3;
        System.out.println(findJudge(n, trust));
    }
}