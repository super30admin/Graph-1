class Solution {
    public int findJudge(int n, int[][] trust) {

        if(n==0)
        {
            return -1;
        }

        int []indegress= new int[n];
        for(int []edge:trust)
        {
            indegress[edge[0]-1]--;
            indegress[edge[1]-1]++;
        }
        for(int i=0;i<n;i++)
        {
            if(indegress[i]==n-1)
            {
                return i+1;
            }
        }
        return -1;
    }
}