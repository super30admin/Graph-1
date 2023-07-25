class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] indegrees = new int[n+1];
        for(int[] pair : trust)
        {
            indegrees[pair[0]] --;
            indegrees[pair[1]] ++;
        }

        for(int i = 1 ; i < indegrees.length; i++)
        {
            if(indegrees[i] == n-1)
                return i;
        }

        return -1;

    }
}