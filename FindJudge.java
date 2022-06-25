/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public int findJudge(int N, int[][] trust) 
    {
        int degree[] = new int[N+1];
        
        for(int tr[]: trust)
        {
            degree[tr[0]]--;
            degree[tr[1]]++;
        }
        
        for(int i = 1; i <= N; i++)
        {
            if(degree[i] == N-1)
                return i;
        }
        
        return -1;
    }
}