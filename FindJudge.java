/**
Time Complexity : O(1)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No 
**/
class Solution 
{
    public int findJudge(int N, int[][] trust) 
    {
        int trustDegree[] = new int[N+1];
        
        for(int trustValue[]:trust)
        {
            trustDegree[trustValue[0]]--;
            trustDegree[trustValue[1]]++;
        }
        
        
        for(int i =1; i<=N; i++)
        {
            if(trustDegree[i] == N-1)
                return i;
        }
        
        return -1;
    }
}