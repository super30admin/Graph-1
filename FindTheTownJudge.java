class Solution {

    public int findJudge(int n, int[][] trust) {
        if (n == 0) {
            return -1;
        }

        int in[] = new int[n + 1];
        for (int i = 0; i < trust.length; ++i) {
            in[trust[i][0]]--;
            in[trust[i][1]]++;
        }

         for (int i = 1; i <= n; ++i) {
            if (in[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }

        
    
    // can be solved using 2 arays or just once array an add or sub
        // 2 arrays - in and out - keep adding. For n = 3, if in is 2 and out is 0 then thats the judge.
    public int findJudge2Array(int n, int[][] trust) {
        if (n == 0) {
            return -1;
        }

        int in[] = new int[n + 1];
        int out[] = new int[n + 1];
        for (int i = 0; i < trust.length; ++i) {
            out[trust[i][0]]++;
            in[trust[i][1]]++;
        }

        for (int i = 1; i <= n; ++i) {
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }

        return -1;
    }


}