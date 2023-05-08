/*
    Time complexity - O(l) where l is the length of the trust array.
    Space complexity - O(n) where n is the no. of people in town.
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[]  trustedBy = new int[n + 1];
        int[]  trusts = new int[n + 1];

        for(int i = 0; i < trust.length; i++) {
            trusts[trust[i][0]]++;
            trustedBy[trust[i][1]]++;
        }

        for(int i = 1; i <= n; i++)
            if(trustedBy[i] == n - 1 && trusts[i] == 0)
                return i;
        
        return -1;
    }
}
