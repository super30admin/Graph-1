package Graph1;

//Time complexity : O(V+E)
//Space complexity: O(V)
public class FindJudge {
    public int findJudge(int n, int[][] trust) {
        int in[] = new int[n];
        for(int[] edge : trust){
            in[edge[1]-1]++;
            in[edge[0]-1]--;
        }
        for(int i=0; i<n; i++){
            if(in[i] == n-1)
                return i+1;
        }
        return -1;
    }
}
