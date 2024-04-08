class Solution {
    public  int findJudge(int n, int[][] trust) {
        // return helper2Array(n, trust);
        return helper1Array(n, trust);
    }

    //Tc: O(e + n)
    //Sc: O(2n)
    private  int helper2Array(int n, int[][] trust) {
        int[] trusting = new int[n + 1];
        int[] trusted = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            trusting[trust[i][0]]++;
            trusted[trust[i][1]]++;
        }

        int ans = -1;

        for (int i = 1; i <= n; i++) {
            if (trusting[i] == 0 && trusted[i] == n - 1)
                ans = i;
        }

        return ans;
    }

    //Tc: O(e + n)
    //Sc: O(n)
    private  int helper1Array(int n, int[][] trust) {
        int[] trustcount = new int[n + 1];

        for (int[] relation : trust) {
            trustcount[relation[0]]--;
            trustcount[relation[1]]++;
        }

        for (int i = 1; i <= n; ++i) {
            if (trustcount[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}