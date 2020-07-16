public class TownJudge {

     /**
     * Time complexity: O(N) where N is given N
     * Space complexity: O(N) where N is given N
     * 
     * Approach:
     * 1. For every person calculate the number of people trusting him and number of people trusted
     * by him.
     */
    public int findJudge(int N, int[][] trust) {

        int[] trustee = new int[N+1];
        int[] isTrusted = new int[N+1];
        
        for(int[] t : trust) {
            if(isTrusted[t[0]] > N)
                return -1;
            isTrusted[t[1]]++;
            trustee[t[0]]++;
        }
        
        for(int i=1; i<=N; i++) {
            if(trustee[i] == 0 && isTrusted[i] == (N-1)) {
                return i;
            }
        }
        return -1;
        
        
    }
}