public class FindJudge {
    //Idea is to use indegrees and out degrees array to find judge with no out degrees and all in degrees.
    //Time Complexity: O(n)
    //Space Complecitty:O(n)
       public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n+1];
        int[] outDegrees = new int[n+1];

        for(int[] tr: trust){
            outDegrees[tr[0]]++;
            indegrees[tr[1]]++;
        }

        for(int i=1; i<=n; i++){
            if(indegrees[i] == n-1 && outDegrees[i] == 0) return i;
        }

        return -1;
    }
}
