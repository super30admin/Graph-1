class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] InOut= new int[n+1][2];
        for(int i=0; i< trust.length; i++){
            int out= trust[i][0];
            int in= trust[i][1];
            InOut[in][0]+= 1; 
            InOut[out][1]+= 1;
        }
        for(int i=1; i<= n; i++){
           if(InOut[i][1]==0 && InOut[i][0] == n-1 )
               return i;
        }
       return -1; 
    }
}
//Time O(E) where E is edge
// space O(n)