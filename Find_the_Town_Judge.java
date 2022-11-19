// TC : O(n)
// SC : O(n)

class Solution {
    public int findJudge(int n, int[][] trust) {
        
        if(n == 0)
            return -1;
        
        int[] hash = new int[n+1];
        
        for(int[] temp : trust) {
            hash[temp[0]]--;
            hash[temp[1]]++;
        }

        for(int i = 1; i <=n ; i++) {
            if(hash[i] == n - 1) {
                return i;
                //System.out.println(i);
            }
        }

        return -1;
    }
}
