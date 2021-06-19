class Solution {
    //Time O(V*E)
    //Space O(V)
    public int findJudge(int n, int[][] trust) {
        int[] InDegrees = new int[n];
        for(int i=0 ; i<trust.length ; i++)
        {
              InDegrees[trust[i][0]-1]--;
              InDegrees[trust[i][1]-1]++;
        }
        for(int i=0 ; i<n ; i++)
        {
            if(InDegrees[i] == n-1)
            {
                return i+1;
            }
        }
        return -1;
    }
}