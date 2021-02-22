//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public int findJudge(int N, int[][] trust) {
    	int []adj=new int[N];
    	for(int i=0;i<trust.length;i++)
        {
            adj[trust[i][0]-1]-=1;
            adj[trust[i][1]-1]+=1;
        }
        for(int i=0;i<N;i++)
        {
            if(adj[i]==N-1)
            {
                return i+1;
            }
        }
        return -1;

    }
}