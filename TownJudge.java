//Time Complexity:O(Vertices + Edges)
//Space Complexity: O(Vertices)
class Solution {
    public int findJudge(int N, int[][] trust) {
        if(N==1){
            return 1;
        }
        int[] indegree = new int[N+1];
        int[] outdegree = new int[N+1];

        for(int i=0;i<trust.length;i++){
            indegree[trust[i][0]]++;
            outdegree[trust[i][1]]++;
        }
        for(int i=0;i<N+1;i++){
            if(outdegree[i] == N-1 && indegree[i] == 0){
                return i;
            }
        }
        return -1;


    }
}