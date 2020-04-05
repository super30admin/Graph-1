# Time complexity:O(V+E)
# Space complexity: 0(V)
# Did code run successfully on leetcode: yes
# Any problem you faced: No



class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] outdegree = new int[N+1];
        int[] indegree = new int[N+1];


        for(int[] edge: trust){
            int a = edge[0];
            int b = edge[1];

            outdegree[a]++;
            indegree[b]++;

        }

        for(int i = 1; i <= N; i++){
            if(outdegree[i] == 0 && indegree[i] == N-1){
                return i;
            }
        }


        return -1;


    }
}

