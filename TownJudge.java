/*
 * tc  - o(E) + o(v)
 * SC - o(n)
 */

public class TownJudge{
    public int findJudge(int n, int[][] trust) {
        int in[] = new int[n+1];
        for(int tr[]: trust){
            in[tr[0]]--;
            in[tr[1]]++;
        }
        for(int i = 1; i < n+1; i++){
            if(in[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}