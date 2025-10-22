/**
TC: O(E) E:length of trust[][]
SC: O(n) n: no of people.
Approach: I would iterate through the trust[][] and would update the inDegree[] and outDegree[]
according to the values. once i am done with all the trust[][], i will loop from 1...n and return the judge if i find any person with n-1 inDegree abd 0 outDegree. else, just return -1.
 */

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustedBy = new int[n+1];
        int[] trusting = new int[n+1];

        for(int[] t : trust){
            int a = t[0]; // depenedent
            int b = t[1]; // independent
            trustedBy[b]++;
            trusting[a]++;
        }

        for(int i =1 ; i <= n ; i++ ){
            if(trustedBy[i] == n-1 && trusting[i] == 0) return i;
        }
     return -1;
    }
}