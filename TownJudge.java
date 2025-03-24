// TC: O(n)
// SC: O(n)
// Did it run successfully on Leetcode? : Yes

public class TownJudge {
    public int findJudge(int n, int[][] trust) {
        int outdegree[] = new int[n+1];
        int indegree[] = new int[n+1];
        for(int i=0;i<trust.length;i++){
            indegree[trust[i][1]]++;
            outdegree[trust[i][0]]++;
        }
        for(int i=1;i<=n;i++){
            if(indegree[i]==n-1 && outdegree[i]==0) return i;
        }
        return -1;
    }
}