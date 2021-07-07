/**

LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(N)

The idea is to use indegrees array to keep count of relationship between members. At the end we will return index with value n-1. The problem is similar to course scheduling problem.
**/

class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if(trust == null || trust.length < 1)
            return 1;
        
        int[] indegrees = new int[N+1];
        
        for(int[] t : trust){
            int one = t[0];
            int two = t[1];
            indegrees[one] --;
            indegrees[two] ++;
        }
        
        for(int i=0; i<indegrees.length;i++){
            if(indegrees[i] == N - 1)
                return i;
        }
        
        return -1;
    }
}
