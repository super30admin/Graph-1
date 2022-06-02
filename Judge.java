public class Judge {

    // Keep track of in degrees and out degrees
        // if any node has in_out degree == n - 1, that's the judge
    // TC : O(V + E)  V - number of vertices   E - number of edges
    // SC : O(E)
    public int findJudge(int n, int[][] trust) {
        if(n == 0 || trust == null) return -1;

        int[] in_out_degrees = new int[n + 1];

        for(int[] t : trust) {
            in_out_degrees[t[0]]--;
            in_out_degrees[t[1]]++;
        }


        for(int i=1; i <= n; i++){
            if(in_out_degrees[i] == n - 1) return i;
        }

        return -1;
    }
}
