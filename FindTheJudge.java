class FindTheJudge {
    public int findJudge(int n, int[][] trust) {
        int indeg[] = new int[n+1];
        for(int[] trustArr : trust)
        {
            indeg[trustArr[0]]--;
            indeg[trustArr[1]]++;
        }

        for(int i=1;i<=n;i++)
        {
            if(indeg[i]==n-1)
            return i;
        }
        return -1;
    }
}

//Time Complexity: O(n + m)
//Space Complexity: O(n)
//n = number of people
//m = length of the trust array