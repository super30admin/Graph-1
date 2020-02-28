// Time Complexity :
//      O(n) where n is the length of trust array
//
// Space Complexity :
//      O(N) where N is the given number of people in the town
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findJudge(int N, int[][] trust) {
        //logic
        int[] trusted = new int[N];
        for(int i=0;i<trust.length;i++)
        {
            trusted[(trust[i][1]-1)]++;
            trusted[(trust[i][0]-1)]--;
        }
        for(int i=0;i<N;i++)
        {
            if(trusted[i] == N-1)
                return (i+1);
        }
        return -1;
    }
}