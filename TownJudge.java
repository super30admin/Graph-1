// T.C -> O(V+E)
// S.C -> O(V)

public class TownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n+1];

        for(int[] p: trust){
            in[p[0]]--;
            in[p[1]]++;
        }

        for(int i=1;i<=n;i++){
            if(in[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}